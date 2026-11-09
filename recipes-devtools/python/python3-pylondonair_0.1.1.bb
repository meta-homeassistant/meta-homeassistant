SUMMARY = "Async Python client for the London Air (Imperial College London) air-quality API"
DESCRIPTION = "Async Python client for the London Air hourly air-quality \
    monitoring index, published by Imperial College London."
HOMEPAGE = "https://github.com/MichaelMKKelly/pylondonair"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c036dbf0b39dcde265cda2bc5b66dede"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "01be82cd373288e2a413f31b97bc8f6fe619ea2b2e23cfd6aa259804ef8f70f6"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-zoneinfo \
    tzdata \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
