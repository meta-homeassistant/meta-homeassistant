SUMMARY = "A Python wrapper for the Discord API forked from discord.py"
HOMEPAGE = "https://github.com/nextcord/nextcord"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b63eb10d4b4860c0a9a87dfda8c0f225"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ed0d1c2ccae6c5acceea13f3c388ded875f21d7378d5ea1330a3d9c6b37e9d93"

DEPENDS = "\
    python3-poetry-dynamic-versioning-native \
"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
	python3-aiohttp (>=3.8.0) \
	python3-typing-extensions (>=4.2.0) \
	python3-audioop-lts (>=0.2.1) \
"

PYPI_PACKAGE = "nextcord"
