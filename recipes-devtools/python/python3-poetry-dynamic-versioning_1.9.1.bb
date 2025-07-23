SUMMARY = "Plugin for Poetry to enable dynamic versioning based on VCS tags"
HOMEPAGE = "https://github.com/mtkennerly/poetry-dynamic-versioning"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=059eed55dbfd3fea022510ea62c95dc1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d6e7b9df817aa2ca4946cd695c6c89e1379d2e6c640f008a9b6170d081a9da48"

inherit pypi python_poetry_core ptest-python-pytest

PYPI_PACKAGE = "poetry_dynamic_versioning"

UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-jinja2 (>=2.11.1) \
    python3-tomlkit (>=0.4) \
    python3-dunamai (>=1.25.0) \
"

BBCLASSEXTEND = "native nativesdk"
