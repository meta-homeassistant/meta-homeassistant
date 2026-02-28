SUMMARY = "Extract swagger specs from your flask project"
HOMEPAGE = "https://github.com/flasgger/flasgger/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7ae72fa68de091da2cbd4c6cf6a11f23"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ca098e10bfbb12f047acc6299cc70a33851943a746e550d86e65e60d4df245fb"

SRC_URI += " \
    file://run-ptest \
"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-flask \
    python3-pyyaml \
    python3-jsonschema \
    python3-mistune \
    python3-packaging \
    python3-six \
"

RDEPENDS:${PN}-ptest += "\
    python3-core \
    python3-apispec \
    python3-flex \
    python3-marshmallow \
    python3-decorator \
    python3-flask-restful \
"

PYPI_PACKAGE = "flasgger"

do_install_ptest:append() {
    cp -rf ${S}/examples ${D}${PTEST_PATH}/
}
