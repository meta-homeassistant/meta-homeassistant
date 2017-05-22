SUMMARY = "API for local communication with LIFX devices over a LAN with asyncio"
HOMEPAGE = "https://github.com/frawau/aiolifx"
LICENSE = "MIT"
# TODO: https://github.com/frawau/aiolifx/issues/8
#LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=60dd5a575c9bd4339411bdef4a702d46"
LIC_FILES_CHKSUM = "file://setup.py;md5=d62f7e3a36765bfe36ddeb4cf81670a7"

inherit pypi setuptools3

SRC_URI[md5sum] = "d36cd6a3bb9d9ef6631b7dff535ef2b8"
SRC_URI[sha256sum] = "cfe52b8af8970c4da94d8ca0bb0a41bb3ffdd1e3977a33dccc1305ee5ad07b3f"

RDEPENDS_${PN} = "${PYTHON_PN}-bitstring"
