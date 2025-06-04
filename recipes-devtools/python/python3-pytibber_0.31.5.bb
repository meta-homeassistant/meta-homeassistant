SUMMARY = "A python3 library to communicate with Tibber"
HOMEPAGE = "https://github.com/Danielhiversen/pyTibber"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7e94c6ffd8e2f56d3686f77cdd1a540a4c6eac5a2f919390bdd14fb62efbb5e8"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI:append = " \
    file://run-ptest \
"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.6) \
    python3-gql (>=3.0.0) \
    python3-websockets (>=10.0) \
"

PTEST_PYTEST_DIR = "test"

PYPI_PACKAGE = "pytibber"
