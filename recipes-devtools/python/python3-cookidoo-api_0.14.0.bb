SUMMARY = "Unofficial package to access Cookidoo."
HOMEPAGE = "https://github.com/miaucl/cookidoo-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=85137d7c5bc6ca071805d43faf5423b3"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3e5018fc0dcc82b0d058281242bd5b888cac705fc7b764250995b3374f7107a4"
SRC_URI = "git://github.com/miaucl/cookidoo-api;protocol=https;tag=${PV};branch=master"

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
