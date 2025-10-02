SUMMARY = "Python 3 support for Egardia / Woonveilig alarm"
HOMEPAGE = "https://github.com/jeroenterheerdt/python-egardia"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=7;endline=7;md5=adc1f231c76ee2f1f36025d56926ba2c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "22afcebe634e67de44a3eaf05c594b6c8a2a81c64ef87288f65c44b7fc090409"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.0)"

PYPI_PACKAGE = "pythonegardia"
