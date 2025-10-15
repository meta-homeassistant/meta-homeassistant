SUMMARY = "Memory efficient way of reading files line-by-line from the end of file"
HOMEPAGE = "https://github.com/RobinNil/file_read_backwards"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=91853fc3cff572c2912cad57e33b97a3"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5478d305ebaeaae8fe3c6585a24dfc3262170224450acc9321398f0d26cdd109"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN}-ptest = "python3-mock"

PYPI_PACKAGE = "file_read_backwards"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
