SUMMARY = "Provides a python interface to interact with a Emby media server."
HOMEPAGE = "https://github.com/mezz64/pyemby"
LICENSE = "MIT"
# TODO: https://github.com/mezz64/pyEmby/pull/3
#LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=78ccb3640dc841e1baecb3e27a6966b2"
LIC_FILES_CHKSUM = "file://setup.py;md5=79e8122a8ee016b6c2a5cc05cdfc1894"

inherit pypi

PYPI_PACKAGE = "pyEmby"

SRC_URI[md5sum] = "c080113fc780419a1269d812a066e96d"
SRC_URI[sha256sum] = "66e51a8a85f3e38389e30d4a3cd8e8625a2b1ae76f4a3e7b789056274128a96b"
