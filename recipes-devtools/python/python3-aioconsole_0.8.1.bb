SUMMARY = "Asynchronous console and interfaces for asyncio"
HOMEPAGE = "https://github.com/vxgmichel/aioconsole"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=783b7e40cdfb4a1344d15b1f7081af66"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0535ce743ba468fb21a1ba43c9563032c779534d4ecd923a46dbd350ad91d234"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "aioconsole"

RDEPENDS:${PN}-ptest:append = "\
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-repeat \
    python3-uvloop \
"

do_install_ptest:append() {
    cat << 'EOF' > ${D}${PTEST_PATH}/pytest.ini
[pytest]
asyncio_mode = auto
EOF
}
