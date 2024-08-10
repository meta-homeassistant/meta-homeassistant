DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/intents"
LICENSE = "CC-BY-4.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "c8a011a33f8c5f5d183583a9d6ce8c0eba26bf9d5841245a733f20832f917601"

PYPI_PACKAGE = "home_assistant_intents"

RDEPENDS:${PN} = "\
    python3-core (>=3.9.0) \
"

RDEPENDS:${PN}-dev += "\
    python3-hassil (>=1.7.1) \
    python3-pyyaml (>=6.0.1) \
    python3-voluptuous (=0.13.1) \
    python3-regex (>=2024.5.15) \
    python3-jinja2 (>=3.1.4) \
"
