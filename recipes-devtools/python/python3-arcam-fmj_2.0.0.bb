SUMMARY = "A python library for speaking to Arcam receivers"
HOMEPAGE = "https://github.com/elupus/arcam_fmj"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=02633dcb18ef987489d49fb00f75ea2b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-add-compatibility-for-pytest-asyncio.patch"
SRC_URI[sha256sum] = "c415446486ec9231fcf822626bc2822736797b92bf10399e8e1bc91f7e30e782"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
	python3-attrs \
"

RDEPENDS:${PN}-ptest = "\
	${PN} \
	python3-aiohttp \
	python3-defusedxml \
	python3-pytest-aiohttp \
	python3-pytest-asyncio \
	python3-pytest-cov \
	python3-pytest-mock \
"

PYPI_PACKAGE = "arcam_fmj"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
