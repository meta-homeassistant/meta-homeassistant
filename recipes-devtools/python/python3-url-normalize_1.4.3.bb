SUMMARY = "URL normalization for Python"
HOMEPAGE = "https://github.com/niksite/url-normalize"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0355248f9f4025eb234b21ac43b9ad7a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d23d3a070ac52a67b83a1c59a0e68f8608d1cd538783b401bc9de2c0fac999b2"

inherit pypi python_poetry_core

do_configure:prepend() {
    sed -i 's#poetry.masonry.api#poetry.core.masonry.api#g' ${S}/pyproject.toml
    sed -i 's#poetry>=#poetry_core>=#g' ${S}/pyproject.toml
}

RDEPENDS:${PN} += "\
    python3-core (>=3.6) \
    python3-six \
"

PYPI_PACKAGE = "url-normalize"
