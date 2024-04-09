DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/intents"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"

inherit pypi python_setuptools_build_meta

SRC_URI += "file://0001-Patch-pyproject.toml-to-use-upstream-version-of-setu.patch"
SRC_URI[sha256sum] = "f68327e6880772ea290275e0013bbdc6504104c79627d453e42fffc49e453812"

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
