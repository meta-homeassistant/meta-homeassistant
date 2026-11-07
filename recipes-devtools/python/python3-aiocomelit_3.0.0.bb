SUMMARY = "Python library to control Comelit Simplehome"
HOMEPAGE = "https://github.com/chemelli74/aiocomelit"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fadb4c1a30a15a1ee80a4dafcd77b3e0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "117a8ba7a7649e4f347d6f7ef4dd27e833f97c61a128139c7fb3a41d8e7f7859"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.12.7) \
    python3-orjson \
    python3-pint \
"

DEPENDS += "python3-wheel-native"
