SUMMARY = "Asynchronous library to retrieve data from air-Q devices."
HOMEPAGE = "https://github.com/CorantGmbH/aioairq"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8729450f6d1bcd9da9abb5ca3ab0e45f92fc414c06f2b09b1812c385de4efa7f"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI:append = " \
    file://run-ptest \
"

PYPI_PACKAGE = "aioairq"
RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-pycryptodome \
"
