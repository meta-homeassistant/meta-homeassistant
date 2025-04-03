SUMMARY = "Python iCalendar implementation (rfc 2445)"
HOMEPAGE = "https://github.com/allenporter/ical"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0d27946eec356536f4addacb63f8b9016b3b06160d77dc2a46981aa55519a2a7"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-pydantic (>=2.10.4) \
    python3-pyparsing (>=3.0.9) \
    python3-dateutil (>=2.8.2) \
    python3-tzdata (>=2023.3) \
"

PYPI_PACKAGE = "ical"
