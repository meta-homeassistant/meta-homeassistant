SUMMARY = "Python Client for the OHF Matter Server"
HOMEPAGE = "https://github.com/matter-js/matterjs-server"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=034ed9796f7ed1e1e1e64267953217f7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/matter-js/matterjs-server;protocol=https;tag=v${PV};nobranch=1"
SRCREV = "63c77d9a28c01009e5307e8e0994261ab60fa6f0"
S = "${UNPACKDIR}/${BP}/python_client"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-dacite \
    python3-orjson \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-aiohttp \
    python3-pytest-asyncio \
    python3-pytest-cov \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
    install -d ${D}${PTEST_PATH}/packages/ws-client/test/fixtures
    install ${S}/../packages/ws-client/test/fixtures/bigint-wire*.json \
        ${D}${PTEST_PATH}/packages/ws-client/test/fixtures/
    install -d ${D}${PTEST_PATH}/python_client
    mv ${D}${PTEST_PATH}/tests ${D}${PTEST_PATH}/python_client/
    mv ${D}${PTEST_PATH}/pyproject.toml ${D}${PTEST_PATH}/python_client/
    # These modules require the built Matter.js server and TypeScript tooling.
    cat > ${D}${PTEST_PATH}/run-ptest << 'EOF'
#!/bin/sh
cd python_client || exit 1
exec pytest --automake --ignore=tests/test_integration.py --ignore=tests/test_client_integration.py
EOF
}

do_configure:prepend() {
    sed -i 's/^version = "0.0.0"/version = "${PV}"/' ${S}/pyproject.toml
}
