SUMMARY = "Python library to access the FYTA API"
HOMEPAGE = "https://fyta.de/"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "56db395ccfd5b377684a2aa489879f383f01f5185eb5966ddcf8d5f8c84a923f"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-mashumaro (>=3.13) \
"

PYPI_PACKAGE = "fyta_cli"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
