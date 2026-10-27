SUMMARY = "An asyncio Python client to access the Evohome web service"
HOMEPAGE = "https://github.com/zxdavb/evohome-async"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=136e4f49dbf29942c572a3a8f6e88a77"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_hatchling ptest-python-pytest

SRC_URI += "file://0001-fix-compilation.patch"
SRC_URI[sha256sum] = "d8aaffaff448dbb32686f7e936de6c3d2d5e42e736ab88b89928bfcefca59d1a"

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.11.12) \
    python3-aiozoneinfo (>=0.2.3) \
    python3-voluptuous (>=0.15.2) \
"

RDEPENDS:${PN}-ptest += "\
    python3-aiofiles (>=24.1.0) \
    python3-aioresponses \
    python3-debugpy (>=1.8.9) \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-freezer \
    python3-pytest-sugar \
    python3-pytest-xdist \
    python3-pyyaml \
    python3-syrupy \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
    cp -r ${S}/_evohome ${S}/evohome_cli ${S}/evohomeasync ${S}/evohomeasync2 ${D}${PTEST_PATH}/
}
