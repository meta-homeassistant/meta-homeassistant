SUMMARY = "Search, filter and sort iCalendar components"
HOMEPAGE = "https://github.com/python-caldav/icalendar-searcher"
LICENSE = "AGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=e6e0db88a9121d8ac23716cccf48bd3b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatch-vcs-native python3-hatchling-native"
SRC_URI[sha256sum] = "abd99bf1ac9c9d675d84151101db4883a97e9958755708804c55abd30df58f6c"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "icalendar_searcher"
RDEPENDS:${PN} = "\
    python3-icalendar (>=6.0) \
    python3-recurring-ical-events (>=3.8.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-icu \
    python3-deptry \
    python3-zoneinfo \
    python3-dateutil-zoneinfo \
"
