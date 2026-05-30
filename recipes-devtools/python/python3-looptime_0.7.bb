SUMMARY = "Fast-forward asyncio event loop time (in tests)"
HOMEPAGE = "https://github.com/nolar/looptime"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=315607e30faf6b4c4903415a97d17056"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-setuptools-scm-native"
SRC_URI[sha256sum] = "6b32eab62d2f11af9d2322a0d120054a38b9eb9380383a427a68155cf34963c4"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-async-timeout \
    python3-codecov \
    python3-coverage \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-mock \
"

PYPI_PACKAGE = "looptime"
