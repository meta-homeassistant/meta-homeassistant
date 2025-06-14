SUMMARY = "The official Python library for the anthropic API"
HOMEPAGE = "https://github.com/anthropics/anthropic-sdk-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2453eb85b33e21e22cb4fa811c650d75"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-hatchling.patch"
SRC_URI[sha256sum] = "f06bc924d7eb85f8a43fe587b875ff58b410d60251b7dc5f1387b322a35bd67b"

DEPENDS += "\
	python3-hatch-fancy-pypi-readme-native \
"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-httpx (>=0.25.0) \
	python3-pydantic (>=1.9.0) \
	python3-typing-extensions (>=4.10) \
	python3-anyio (>=3.5.0) \
	python3-distro (>=1.7.0) \
	python3-sniffio \
	python3-jiter (>=0.4.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"

PYPI_PACKAGE = "anthropic"
