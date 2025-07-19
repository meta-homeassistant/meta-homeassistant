SUMMARY = "python bindings for the miniaudio library and its decoders (mp3, flac, ogg vorbis, wav)"
HOMEPAGE = "https://github.com/irmen/pyminiaudio"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1546904731ab7752de3bc2c7cb005936"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-cffi-native"
SRC_URI[sha256sum] = "e88e97837d031f0fb6982394218b6487de02eaa382ad273b8fca37791a2b4b15"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "miniaudio"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3) \
    python3-attrs \
    python3-multidict \
    python3-yarl \
"
