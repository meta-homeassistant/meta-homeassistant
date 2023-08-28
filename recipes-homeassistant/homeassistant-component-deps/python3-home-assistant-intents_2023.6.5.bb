DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/intents"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"

inherit pypi python_setuptools_build_meta

SRC_URI += "file://0001-Patch-pyproject.toml-to-use-upstream-version-of-setu.patch"
SRC_URI[sha256sum] = "3acad59aa97e4b07c6ec8aa35eca21651e98fb21532602667fbd56136ebe56cc"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-hassil (=1.0.6) \
    ${PYTHON_PN}-pyyaml (=6.0) \
    ${PYTHON_PN}-voluptuous (=0.13.1) \
    ${PYTHON_PN}-regex (>=2023.3.23) \
    ${PYTHON_PN}-jinja2 (=3.1.2) \
"
