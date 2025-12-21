SUMMARY = "The official Python library for the anthropic API"
HOMEPAGE = "https://github.com/anthropics/anthropic-sdk-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2453eb85b33e21e22cb4fa811c650d75"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-hatchling.patch"
SRC_URI[sha256sum] = "e8607422f4ab616db2ea5baacc215dd5f028da99ce2f022e33c7c535b29f3dfb"

DEPENDS += "\
	python3-hatch-fancy-pypi-readme-native \
"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "\
	python3-aiohttp \
	python3-docstring-parser \
	python3-httpx-aiohttp \
    python3-httpx (>=0.25.0) \
	python3-pydantic (>=1.9.0) \
	python3-typing-extensions (>=4.10) \
	python3-anyio (>=3.5.0) \
	python3-distro (>=1.7.0) \
	python3-sniffio \
	python3-jiter (>=0.4.0) \
"

RDEPENDS:${PN}-ptest += "\
	python3-botocore \
	python3-dirty-equals \
	python3-inline-snapshot \
	python3-pytest-xdist \
	python3-respx \
	python3-tests \
    python3-pytest-asyncio \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
	# The following items are added as tests need these files
    install ${S}/README.md ${D}${PTEST_PATH}/
}


PYPI_PACKAGE = "anthropic"
