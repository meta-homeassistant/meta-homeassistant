SUMMARY = "A Python library for interacting with Android TV using the Android TV Remote protocol v2"
HOMEPAGE = "https://github.com/tronikos/androidtvremote2"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# The PyPI sdist omits tests/conftest.py and tests/__init__.py, which the
# tests import from; build from the release tag so the ptest is complete.
SRC_URI = "git://github.com/tronikos/androidtvremote2.git;protocol=https;tag=v${PV};nobranch=1"
SRCREV = "3f30c275615fc5eb11b4a2da4fe33a02cbb4fd66"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiofiles (>=0.8) \
    python3-cryptography (>=3) \
    python3-protobuf (>=4.21) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"

do_install_ptest:append() {
    # asyncio_mode and the fixture loop scope come from pyproject.toml
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
