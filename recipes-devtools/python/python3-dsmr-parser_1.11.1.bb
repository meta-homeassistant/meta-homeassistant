SUMMARY = "Library to parse Dutch Smart Meter Requirements (DSMR)"
HOMEPAGE = "https://github.com/ndokter/dsmr_parser"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=045ec63f3da7e6ac236ecbde8ce6f7a0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/ndokter/dsmr_parser;protocol=https;branch=master;tag=v${PV}"
SRCREV = "4ad6ff1cbe177c8e2e81b40fb404ea63a9479c46"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-serialx \
    python3-tailer (>=0.4.1) \
    python3-dlms-cosem (>=21.3.2) \
"

RDEPENDS:${PN}-ptest:append = "\
    python3-zoneinfo \
    python3-tzdata \
    python3-misc \
"

PTEST_PYTEST_DIR = "test"
