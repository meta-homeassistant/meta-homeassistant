SUMMARY = "CalDAV (RFC4791) client library"
HOMEPAGE = "https://github.com/python-caldav/caldav"
LICENSE = "Apache-2.0 & GPL-3.0-only"
LIC_FILES_CHKSUM = "\
    file://COPYING.APACHE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
    file://COPYING.GPL;md5=d32239bcb673463ab874e80d47fae504 \
"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0b6dc76a462c0c32a6dbdc537eda832226bd4d9dacf3906247626b68db5b10b6"

DEPENDS += "python3-setuptools-scm-native python3-hatch-vcs-native"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "caldav"
RDEPENDS:${PN} = "\
    python3-lxml \
    python3-niquests \
    python3-recurring-ical-events (>=2.0.0) \
    python3-icalendar (>=6.0.0) \
    python3-icalendar-searcher (>=1.0.5) \
    python3-dnspython \
    python3-dateutil \
    python3-pyyaml \
"

RDEPENDS:${PN}-ptest += "\
    bash \
    python3-vobject \
    python3-pytest-asyncio \
    python3-coverage \
    python3-tzlocal \
    python3-xandikos \
    python3-radicale \
    python3-pyfakefs \
    python3-httpx \
    python3-deptry \
"
