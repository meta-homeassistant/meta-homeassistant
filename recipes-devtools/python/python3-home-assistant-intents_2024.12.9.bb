DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/intents"
LICENSE = "CC-BY-4.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "b987859321dc148de5719d92721b36ebbb62ddeea742bf9f449b4af312f7732c"

PYPI_PACKAGE = "home_assistant_intents"

RDEPENDS:${PN} = "\
    python3-core (>=3.9.0) \
"
