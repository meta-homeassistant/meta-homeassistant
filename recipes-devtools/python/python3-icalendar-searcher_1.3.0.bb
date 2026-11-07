SUMMARY = "Search, filter and sort iCalendar components"
HOMEPAGE = "https://github.com/python-caldav/icalendar-searcher"
LICENSE = "GPL-3.0-or-later OR Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING.GPL;md5=d32239bcb673463ab874e80d47fae504 \
                    file://COPYING.APACHE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatch-vcs-native python3-hatchling-native"
SRC_URI[sha256sum] = "9cf9b881c54b596bf5867e226fd7044603a124d6bb3cf879171854d39027475e"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-icalendar (>=6.2.0) \
    python3-recurring-ical-events (>=3.8.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-icu \
    python3-deptry \
    python3-zoneinfo \
    python3-dateutil-zoneinfo \
"
