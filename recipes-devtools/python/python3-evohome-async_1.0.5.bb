SUMMARY = "An asyncio Python client to access the Evohome web service"
HOMEPAGE = "https://github.com/zxdavb/evohome-async"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=136e4f49dbf29942c572a3a8f6e88a77"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_hatchling ptest-python-pytest

SRC_URI += "file://0001-fix-compilation.patch"
SRC_URI[sha256sum] = "804b3861f77c4f8daee7e4c4ee33ba6d32295665727127f4fbae34a8eb9a9778"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.11.11) \
    python3-aiozoneinfo (>=0.2.1) \
    python3-voluptuous (>=0.15.2) \
    python3-aiofiles (>=24.1.0) \
    python3-debugpy (>=1.8.9) \
    python3-credentials-manager \
"

PYPI_PACKAGE = "evohome_async"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
