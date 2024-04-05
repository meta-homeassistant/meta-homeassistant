DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/intents"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"

inherit pypi python_setuptools_build_meta

SRC_URI += "file://0001-Patch-pyproject.toml-to-use-upstream-version-of-setu.patch"
SRC_URI[sha256sum] = "1269da61cf8bd4f1cebfa33ba1d60397e5016642c946d3fceb13e8a9d6ee3aa5"

RDEPENDS:${PN} = "\
    python3-core (>=3.9.0) \
"

RDEPENDS:${PN}-dev += "\
    python3-hassil (>=1.6.1) \
    python3-pyyaml (>=6.0.1) \
    python3-voluptuous (=0.13.1) \
    python3-regex (>=2023.12.25) \
    python3-jinja2 (>=3.1.3) \
"
