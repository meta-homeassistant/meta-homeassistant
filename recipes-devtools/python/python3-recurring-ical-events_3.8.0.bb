SUMMARY = "Calculate recurrence times of events, todos, alarms and journals based on icalendar RFC5545."
HOMEPAGE = "https://recurring-ical-events.readthedocs.io/"
LICENSE = "LGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3000208d539ec061b899bce1d9ce9404"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3e8c7c35d9bd8956a7ab91afad51477c60d972e1236d3fd1b55087a66bce7d04"

DEPENDS = "\
    python3-hatch-vcs-native \
"

inherit pypi python_hatchling

RDEPENDS:${PN} += "\
	python3-icalendar (>=6.1.0) \
    python3-dateutil (>=2.8.1) \
    python3-x-wr-timezone (>=1.0.0) \
    python3-tzdata \
"

PYPI_PACKAGE = "recurring_ical_events"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
