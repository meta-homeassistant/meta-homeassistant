SUMMARY = "A package to control Midea CCM15 data converter modules"
HOMEPAGE = "https://github.com/ocalvo/py-ccm15"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=05c3699530a6333eccd103eeafd3c20b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "55c4af88abfa4ae86dac0ecc6792c5cd6cb8fdb1cef41d8196976c735b9b15e2"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-httpx (>=0.24.1) \
	python3-xmltodict (>=0.13.0) \
	python3-aiohttp (>=3.8.5) \
"

PYPI_PACKAGE = "py_ccm15"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
