DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/intents"
LICENSE = "CC-BY-4.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI[sha256sum] = "4086dcdf98bf7e5474e141dc969b7861962ac1552a48beaf66f8987c0d8010a0"

PYPI_PACKAGE = "home_assistant_intents"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-core (>=3.9.0) \
"
