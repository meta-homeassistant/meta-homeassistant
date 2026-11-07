SUMMARY = "An unofficial reverse engineered Husqvarna Automower Connect BLE library"
HOMEPAGE = "https://github.com/alistair23/AutoMower-BLE"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6684f155bffc9656a8b7246a96aa2d452d04bf69db22771e94c065cd2fdab8e3"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "python3-bleak python3-bleak-retry-connector"
