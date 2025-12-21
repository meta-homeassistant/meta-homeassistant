SUMMARY = "Python Daikin HVAC appliances interface"
HOMEPAGE = "https://github.com/fredrike/pydaikin.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "dadeef022084a4f0776e90451746a453aa7040a12a83a95275f0c9af6fdaf622"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-netifaces \
    python3-aiohttp \
    python3-urllib3 \
    python3-tenacity \
"

PYPI_PACKAGE = "pydaikin"
