SUMMARY = "Devialet API"
HOMEPAGE = "https://github.com/fwestenberg/devialet"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9912f72ab3db23de2af9d399b440c0f7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "75b3cc9eb42961a32820b1062d10c96312972f333eff85ff82ad8bc05eff2cd0"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp python3-async-upnp-client"

PYPI_PACKAGE = "devialet"
