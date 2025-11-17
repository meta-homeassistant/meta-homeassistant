SUMMARY = "Tools to expand Python's enum module."
HOMEPAGE = "https://github.com/domdfcoding/enum_tools"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3000208d539ec061b899bce1d9ce9404"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com"

SRC_URI[sha256sum] = "0d13335e361d300dc0f8fd82c8cf9951417246f9676144f5ee1761eb690228eb"

DEPENDS = "\
	python3-whey-native \
	python3-attrs-native \
	python3-natsort-native \
	python3-consolekit-native \
	python3-pyproject-parser-native \
	python3-click-native \
	python3-dist-meta-native \
	python3-domdf-python-tools-native \
	python3-dm-toml-native \
	python3-shippinglabel-native \
	python3-handy-archives-native \
"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
	python3-pygments (>=2.6.1) \
	python3-typing-extensions (>=3.7.4.3) \
"

PYPI_PACKAGE = "enum_tools"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
