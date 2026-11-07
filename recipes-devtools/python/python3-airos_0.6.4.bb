SUMMARY = "Ubiquiti airOS module(s) for Python 3."
HOMEPAGE = "https://github.com/compatech/python-airos"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b6ad717ddaae2251044bbbb7bd265b2a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/compatech/python-airos;protocol=https;tag=v${PV};branch=main \
           file://0001-relax-build-requirement.patch \
           "
SRCREV = "fbd3aed87fbc8c612538217b9140bdc29e5ccae1"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-aiohttp (>=3.13.3) \
	python3-mashumaro (>=3.20) \
"

RDEPENDS:${PN}-ptest:append = "\
	python3-pytest-asyncio \
	python3-pytest-cov \
	python3-coverage \
	python3-aioresponses \
	python3-aiofiles \
	python3-pydantic \
"

do_install_ptest:append() {
	install ${S}/pyproject.toml ${D}${PTEST_PATH}/
    install -d ${D}${PTEST_PATH}/fixtures/userdata/
    cp -rf ${S}/fixtures/* ${D}${PTEST_PATH}/fixtures/
}
