SUMMARY = "Deebot client library in python 3"
HOMEPAGE = "https://github.com/DeebotUniverse/client.py"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1f93da745c75a0733bed8bfc53d4436f17e604167413c9177d58565f23a317a3"

require ${BPN}-crates.inc

inherit pypi python_maturin cargo-update-recipe-crates pkgconfig

RDEPENDS:${PN} += "\
	python3-aiohttp (>=3.10) \
	python3-aiomqtt (>=2.0.0) \
	python3-cachetools (>=5.0.0) \
	python3-defusedxml (>=0.7.1) \
    python3-orjson \
"
