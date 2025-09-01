SUMMARY = "CalDAV (RFC4791) client library"
HOMEPAGE = "https://github.com/python-caldav/caldav"
LICENSE = "Apache-2.0 & GPL-3.0-only"
LIC_FILES_CHKSUM = "\
    file://COPYING.APACHE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
    file://COPYING.GPL;md5=d32239bcb673463ab874e80d47fae504 \
"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatch-vcs-native python3-hatchling-native"
SRC_URI[sha256sum] = "04da40b0b0433a0f53f6fb678b636fa29296013ed262754c73611453362c6ac0"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "caldav"
RDEPENDS:${PN} = "\
    python3-lxml \
    python3-requests \
    python3-recurring-ical-events (>=2.0.0) \
    python3-icalendar (>=6.0.0) \
"
