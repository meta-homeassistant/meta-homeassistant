SUMMARY = "Implements a fake file system that mocks the Python file system modules."
HOMEPAGE = "https://github.com/pytest-dev/pyfakefs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=34400b68072d710fecd0a2940a0d1658"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e59a36db447bf509ce9c97ab3d1510c08cc51895c5311325a560a5e5b5dc1940"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN}:append = " \
    python3-fcntl \
    python3-io \
    python3-logging \
    python3-pytest \
    python3-shell \
    python3-unittest \
"
