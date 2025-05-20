SUMMARY = "Send responses to httpx."
HOMEPAGE = "https://github.com/Colin-b/pytest_httpx"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=80d06bde9296c367ea063b11e9518842"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "python3-setuptools-scm-native"

SRC_URI[sha256sum] = "d619ad5d2e67734abfbb224c3d9025d64795d4b8711116b1a13f72a251ae511f"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "pytest_httpx"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
RDEPENDS:${PN} = "python3-httpx python3-pytest"
