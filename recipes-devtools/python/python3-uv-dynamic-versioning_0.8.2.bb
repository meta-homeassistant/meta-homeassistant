SUMMARY = "Dynamic versioning based on VCS tags for uv/hatch project"
HOMEPAGE = "https://github.com/ninoseki/uv-dynamic-versioning/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=14d953809f6381e54162e13c2c846fbc"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "a9c228a46f5752d99cfead1ed83b40628385cbfb537179488d280853c786bf82"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-dunamai \
    python3-hatchling \
    python3-jinja2 \
    python3-pydantic \
    python3-tomlkit \
"

PYPI_PACKAGE = "uv_dynamic_versioning"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

BBCLASSEXTEND = "native nativesdk"
