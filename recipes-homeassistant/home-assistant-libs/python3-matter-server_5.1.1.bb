SUMMARY = "Python server to interact with Matter"
HOMEPAGE = "https://github.com/home-assistant-libs/python-matter-server"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c5a0d917e64171a83d11a738274272f6"

SRC_URI[sha256sum] = "cdda1033e22930d06cef6e9596922feb06f68a3d2fb75899c2d0d3f6a8ec3539"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "python-matter-server"

RDEPENDS:${PN} += "\
	python3-aiohttp \
	python3-aiorun \
	python3-async-timeout \
	python3-core (>= 3.10) \
	python3-coloredlogs \
	python3-dacite \
	python3-orjson \
	python3-home-assistant-chip-clusters (=2023.12.0) \
"