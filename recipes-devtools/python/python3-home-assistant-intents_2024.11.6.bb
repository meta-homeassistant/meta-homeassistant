DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/intents"
LICENSE = "CC-BY-4.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "4b8072a839dfa658a8033dc963bff1190b6bcbb1ca92f680f4bc0c483d2d6a7d"

PYPI_PACKAGE = "home_assistant_intents"

RDEPENDS:${PN} = "\
    python3-core (>=3.9.0) \
"
