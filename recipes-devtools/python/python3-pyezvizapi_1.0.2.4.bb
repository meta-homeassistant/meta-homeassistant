SUMMARY = "Pilot your Ezviz cameras"
HOMEPAGE = "https://github.com/RenierM26/pyEzvizApi/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327 \
                    file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Remove-unnecessary-setup_requires-from-setup.py.patch"
SRC_URI[sha256sum] = "9b951b07d3fb70e1731950ba67956f980b2d8de830bad9b98b4b485e112499fb"

DEPENDS = "python3-requests-native"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-paho-mqtt python3-pandas python3-pycryptodome python3-requests python3-xmltodict"

PYPI_PACKAGE = "pyezvizapi"
