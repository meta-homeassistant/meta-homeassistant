SUMMARY = "Python API for talking to Ecobee thermostats"
HOMEPAGE = "https://github.com/nkgilley/python-ecobee-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3f8a87dd19c26a92634df2aa8a6daba5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "20d9b4637ce2b61f6dec33829e36c5d7c7629830cedf4cc4bf61d5737f6ce5f3"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.25)"

PYPI_PACKAGE = "python_ecobee_api"
