SUMMARY = "Python API for talking to Ecobee thermostats"
HOMEPAGE = "https://github.com/nkgilley/python-ecobee-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3f8a87dd19c26a92634df2aa8a6daba5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f6a70468a23dbd68d7572381d0fb12490321d3c03d024278da9881acc529a221"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.25)"
