SUMMARY = "Library to parse Dutch Smart Meter Requirements (DSMR)"
HOMEPAGE = "https://github.com/ndokter/dsmr_parser"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=045ec63f3da7e6ac236ecbde8ce6f7a0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/ndokter/dsmr_parser;protocol=https;branch=master"

SRCREV = "e20e831e8197401f1a492b9cb604e2651f3569f1"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-tailer (>=0.4.1) \
    python3-dlms-cosem (>=21.3.2) \
    python3-pyserial (>=3) \
    python3-pyserial-asyncio-fast (>=0.11) \
    python3-pytz \
"
