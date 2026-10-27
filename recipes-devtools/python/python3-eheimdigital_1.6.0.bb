SUMMARY = "Offers a Python API for the EHEIM Digital smart aquarium devices."
HOMEPAGE = "https://codeberg.org/autinerd/eheimdigital"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8addaa1c6ef4e78a2c320750041e629b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-repair-test.patch"
SRC_URI[sha256sum] = "081fceca5d809c4a5e455e0536498814138dd93232e1d025e4201dbcad9c18c3"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-yarl \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
