SUMMARY = "foscam camera cgi"
HOMEPAGE = "https://github.com/Foscam-wangzhengyu/libfoscamcgi"
LICENSE = "LGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "53543f47fbb0695fe708b872e97c4a8c65215ebc3d7d7eba01c0ed50f2c62e74"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-defusedxml"

PYPI_PACKAGE = "libpyfoscamcgi"
