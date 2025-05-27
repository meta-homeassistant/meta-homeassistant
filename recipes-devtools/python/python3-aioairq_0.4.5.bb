SUMMARY = "Asynchronous library to retrieve data from air-Q devices."
HOMEPAGE = "https://github.com/CorantGmbH/aioairq"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a9be4144b3efbc3e2ee44b7d08ec5415f2e61719b09fa2f5b9a91d9b2552c763"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI:append = " \
    file://run-ptest \
"

PYPI_PACKAGE = "aioairq"
RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-pycryptodome \
"
