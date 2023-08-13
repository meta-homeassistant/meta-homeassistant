DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/hassil/tree/v1.0.6"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"

inherit pypi python_setuptools_build_meta

SRC_URI += "file://0001-Patch-pyproject.toml-to-use-upstream-version-of-setu.patch"
SRC_URI[sha256sum] = "ad37a5088d2fccc12a638f66723ad40932cac7ed9ff9731137244b35a010b1b4"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-hassil (=1.0.6) \
    ${PYTHON_PN}-pyyaml (=6.0) \
    ${PYTHON_PN}-voluptuous (=0.13.1) \
    ${PYTHON_PN}-regex (>=2023.3.23) \
    ${PYTHON_PN}-jinja2 (=3.1.2) \
"
