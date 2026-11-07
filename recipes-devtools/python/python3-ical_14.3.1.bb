SUMMARY = "Python iCalendar implementation (rfc 2445)"
HOMEPAGE = "https://github.com/allenporter/ical"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/allenporter/ical.git;protocol=https;branch=release/14.3;tag=${PV}"
SRCREV = "37c0e100bb6e7df9255ccf72a4a4370e373a9e9a"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-dateutil (>=2.8.2) \
    python3-pydantic (>=2.10.4) \
    python3-tzdata (>=2023.3) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-aiohttp \
    python3-pytest-asyncio \
    python3-aiohttp \
    python3-emoji \
    python3-freezegun \
    python3-pytest-cov \
    python3-pyyaml \
    python3-syrupy \
    python3-pytest-benchmark \
    python3-misc \
    python3-statistics \
"

do_install_ptest:append() {
    # asyncio_mode = auto (async tests) and --benchmark-skip come from pytest.ini
    install -m 0644 ${S}/pytest.ini ${D}${PTEST_PATH}/
    # test_build_doc tests the documentation build script, not the library
    rm -f ${D}${PTEST_PATH}/tests/test_build_doc.py
}
