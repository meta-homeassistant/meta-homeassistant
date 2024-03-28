DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/intents"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"

inherit pypi python_setuptools_build_meta

SRC_URI += "file://0001-Patch-pyproject.toml-to-use-upstream-version-of-setu.patch"
SRC_URI[sha256sum] = "d6d440af78cf1cfb8dff49168f9cd7970abe0e4b23f17631f7427a414b3b6867"

RDEPENDS:${PN} = "\
    python3-hassil (>=1.5.1) \
    python3-pyyaml (>=6.0.1) \
    python3-voluptuous (=0.13.1) \
    python3-regex (>=2023.10.3) \
    python3-jinja2 (>=3.1.2) \
    python3-core (>=3.9.0) \
"
