SUMMARY = "Repair Google Calendar - This Python module and program makes ICS/iCalendar files using X-WR-TIMEZONE compatible with the RFC 5545 standard."
HOMEPAGE = "https://github.com/niccokunzmann/x-wr-timezone"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3000208d539ec061b899bce1d9ce9404"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9166c40e6ffd4c0edebabc354e1a1e2cffc1bb473f88007694793757685cc8c3"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-click \
    python3-icalendar (>=6.1.0) \
    python3-tzdata \
"

PYPI_PACKAGE = "x_wr_timezone"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
