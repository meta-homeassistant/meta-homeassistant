SUMMARY = "Async UPnP Client for Python"
HOMEPAGE = "https://github.com/StevenLooman/async_upnp_client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f4eda51018051de136d3b3742e9a7a40"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit python_setuptools_build_meta ptest-python-pytest

SRC_URI[sha256sum] = "3a5edefff0f7e635503ce849d6638ad668ae5459ca7aff07bf893b143eead90b"
SRC_URI = "git://github.com/StevenLooman/async_upnp_client.git;protocol=https;tag=${PV};branch=development"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.1) \
    python3-async-timeout (>=3.0.0) \
    python3-core (>=3.8) \
    python3-defusedxml (>=0.6.0) \
    python3-python-didl-lite (=1.4.0) \
    python3-voluptuous (>=0.15.2) \
"

RDEPENDS:${PN}-ptest:append = " \
    python3-pytest-aiohttp \
    python3-pytest-asyncio \
"

do_install_ptest:append() {
    cat << 'EOF' > ${D}${PTEST_PATH}/pytest.ini
[pytest]
asyncio_mode = auto
EOF
}
