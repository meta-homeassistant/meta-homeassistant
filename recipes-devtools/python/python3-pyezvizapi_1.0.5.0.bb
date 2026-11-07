SUMMARY = "Pilot your Ezviz cameras"
HOMEPAGE = "https://github.com/RenierM26/pyEzvizApi/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327 \
                    file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0f7346a10bedb3d000a1e4edc933ec34fdba1a41135e31c4fa8a962789d373a3"

DEPENDS += "python3-wheel-native"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "python3-paho-mqtt python3-pycryptodome python3-requests python3-xmltodict"
