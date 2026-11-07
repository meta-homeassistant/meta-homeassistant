SUMMARY = "Unofficial package to access Cookidoo."
HOMEPAGE = "https://github.com/miaucl/cookidoo-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=85137d7c5bc6ca071805d43faf5423b3"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/miaucl/cookidoo-api;protocol=https;tag=${PV};branch=master"
SRCREV = "719a481597aa1820db66abbeb8694a9ff6e7b212"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-aiohttp \
	python3-aiofiles \
	python3-isodate \
"

RDEPENDS:${PN}-ptest:append = "\
	python3-pytest-cov \
	python3-pytest-asyncio \
	python3-python-dotenv \
	python3-aioresponses \
	python3-tests \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
