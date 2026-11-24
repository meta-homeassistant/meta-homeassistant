SUMMARY = "Python library for DIO Chacon wifi's protocol for shutters and switches"
HOMEPAGE = "https://github.com/cnico/dio-chacon-wifi-api"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/cnico/dio-chacon-wifi-api;protocol=https;branch=main;tag=v${PV}"
SRCREV = "1fdd5ee9e30e5b56408f2869e2a2220ff8faca81"

inherit python_poetry_core ptest-python-pytest

RDEPENDS:${PN} += " \
    python3-aiohttp (>=3.9.3) \
"
