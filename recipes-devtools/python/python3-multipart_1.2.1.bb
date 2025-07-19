SUMMARY = "Parser for multipart/form-data"
HOMEPAGE = "https://multipart.readthedocs.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e67eb8de09d13df51e53dd996e7d5c48"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "829b909b67bc1ad1c6d4488fcdc6391c2847842b08323addf5200db88dbe9480"

inherit pypi python_flit_core ptest-python-pytest

PYPI_PACKAGE = "multipart"
