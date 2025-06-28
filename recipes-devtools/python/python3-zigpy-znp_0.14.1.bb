SUMMARY = "A library for zigpy which communicates with TI ZNP radios"
HOMEPAGE = "https://github.com/zigpy/zigpy-znp"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI:append = " file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "bfd8cba410542391d00ae3f439ad875c93063e259fed203990cccf84801a4939"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "zigpy_znp"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-async-timeout \
    python3-coloredlogs \
    python3-jsonschema \
    python3-voluptuous \
    python3-zigpy (>=0.70.0) \
"


RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-timeout \
"
