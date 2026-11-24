SUMMARY = "A package to control Midea CCM15 data converter modules"
HOMEPAGE = "https://github.com/ocalvo/py-ccm15"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=05c3699530a6333eccd103eeafd3c20b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "39fffd4a73857647d368137d3d86961a1cfd34b54c5cd56a1c7f629202265b2f"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-httpx (>=0.24.1) \
	python3-xmltodict (>=0.13.0) \
"
