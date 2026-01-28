SUMMARY = "Travel through time in your tests."
HOMEPAGE = "https://github.com/adamchainz/time-machine"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb9b93a440d3ef2fb6eeebfa59384c53"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a4ddd1cea17b8950e462d1805a42b20c81eb9aafc8f66b392dd5ce997e037d79"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "time_machine"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
