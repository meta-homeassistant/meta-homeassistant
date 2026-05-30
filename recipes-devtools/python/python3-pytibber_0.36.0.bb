SUMMARY = "A python3 library to communicate with Tibber"
HOMEPAGE = "https://github.com/Danielhiversen/pyTibber"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b767be1abc19119c8a47c60ba84e749db983d1ec1b018052731ee322aac3f727"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI:append = " \
    file://run-ptest \
"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.6) \
    python3-gql (>=4.0.0) \
    python3-websockets (>=14.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"

PTEST_PYTEST_DIR = "test"

PYPI_PACKAGE = "pytibber"
