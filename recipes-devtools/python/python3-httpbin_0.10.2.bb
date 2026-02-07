SUMMARY = "HTTP Request and Response Service"
HOMEPAGE = "https://github.com/psf/httpbin"
LICENSE = "ISC & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=93a3b190099e50096ce1e4b4d2f83059 \
                    file://LICENSE.ISC;md5=0b1d7a7639cdb11cdcf50ff2fc5a5b3b \
                    file://LICENSE.MIT;md5=138d4be72f7275b6866098981c67dde4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "632148698261c8684ea2d2b624cdea845b402b1fe91736e89df886408c6317a9"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "httpbin"

RDEPENDS:${PN} = "\
    python3-brotlicffi \
    python3-decorator \
    python3-flasgger \
    python3-greenlet \
    python3-six \
    python3-werkzeug \
"
