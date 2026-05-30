SUMMARY = "Lightweight CalDAV/CardDAV server"
HOMEPAGE = "https://www.xandikos.org/"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI[sha256sum] = "a80b3398f5400f39c96244a76cb5e4fa71d2b764ae713c4b8b5bae180df24834"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "xandikos"

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-icalendar (>=5.0.4) \
    python3-dulwich (>=0.25.0) \
    python3-defusedxml \
    python3-jinja2 \
    python3-multidict \
    python3-vobject \
"

RDEPENDS:${PN}-ptest += "\
    python3-dateutil-zoneinfo \
    python3-zoneinfo \
"
