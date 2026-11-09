SUMMARY = "A python library for speaking to Arcam receivers"
HOMEPAGE = "https://github.com/elupus/arcam_fmj"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=02633dcb18ef987489d49fb00f75ea2b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-add-compatibility-for-pytest-asyncio.patch"
SRC_URI[sha256sum] = "d13c85b50832907a2cf2bdd51339008d3871b5f0140bb56f742aa16f127c83b4"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "\
	python3-attrs \
    python3-serialx \
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

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}

DEPENDS += "python3-uv-dynamic-versioning-native"
