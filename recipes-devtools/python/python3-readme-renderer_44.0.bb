SUMMARY = "readme_renderer is a library for rendering readme descriptions for Warehouse"
HOMEPAGE = "https://github.com/pypa/readme_renderer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8cc789b082b3d97e1ccc5261f8594d3f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8712034eabbfa6805cacf1402b4eeb2a73028f72d1166d6f5cb7f9c047c5d1e1"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "readme_renderer"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-docutils (>=0.21.2) \
    python3-pygments (>=2.5.1) \
"

BBCLASSEXTEND = "native nativesdk"
