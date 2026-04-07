SUMMARY = "Python wrapper for EcoWitt Protocol"
HOMEPAGE = "https://github.com/home-assistant-libs/aioecowitt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8a701d4d0c5ad6a64c5706b3e7b649f4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/home-assistant-libs/aioecowitt;protocol=https;tag=${PV};branch=main"
SRCREV = "a9ed7e4ea2aceb8ecc2779f34b7c0f890ec57859"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-aiohttp (>=3) \
	python3-meteocalc (>=1.1.0) \
"

RDEPENDS:${PN}-ptest:append = "\
	python3-pytest-aiohttp \
	python3-pytest-asyncio \
	python3-pytest-timeout \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
