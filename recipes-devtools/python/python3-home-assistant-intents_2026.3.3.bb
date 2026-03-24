DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/intents"
LICENSE = "CC-BY-4.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI[sha256sum] = "1bd300c6675d787087beac28d17c617a684beb1297ffd56b81813f3208804669"

PYPI_PACKAGE = "home_assistant_intents"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
