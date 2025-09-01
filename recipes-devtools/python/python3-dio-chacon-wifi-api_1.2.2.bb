SUMMARY = "Python library for DIO Chacon wifi's protocol for shutters and switches"
HOMEPAGE = "https://github.com/cnico/dio-chacon-wifi-api"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/cnico/dio-chacon-wifi-api;protocol=https;branch=main"
SRC_URI[sha256sum] = "94ea4855cdfd542f69c215f2f705382ab6275ce3ddc4065ab7da0ed7eae7b40e"

SRCREV = "87e0645c43e97b174a11d418c6231686ae0f8d12"

inherit python_poetry_core ptest-python-pytest

RDEPENDS:${PN} += " \
    python3-aiohttp (>=3.9.3) \
"
