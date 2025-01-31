SUMMARY = "Python iCalendar implementation (rfc 2445)"
HOMEPAGE = "https://github.com/allenporter/ical"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "4d3c8c215230c18b1544d11f8e3342301943b5c6fc1b9980442735b84f8015cd"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-pydantic (>=2.10.4) \
    python3-pyparsing (>=3.0.9) \
    python3-dateutil (>=2.8.2) \
    python3-tzdata (>=2023.3) \
"

PYPI_PACKAGE = "ical"
