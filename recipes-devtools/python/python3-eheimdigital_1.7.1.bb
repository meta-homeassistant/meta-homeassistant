SUMMARY = "Offers a Python API for the EHEIM Digital smart aquarium devices."
HOMEPAGE = "https://codeberg.org/autinerd/eheimdigital"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8addaa1c6ef4e78a2c320750041e629b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-repair-test.patch"
SRC_URI[sha256sum] = "cea3339da6a24631489355a9a316a3dead2bd32eb820e07bcd2c2f52ca5e7162"

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
