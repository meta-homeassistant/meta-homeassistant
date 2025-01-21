SUMMARY = "Python interface for the AlarmDecoder (AD2) family of alarm devices which includes the AD2USB, AD2SERIAL and AD2PI."
HOMEPAGE = "http://github.com/nutechsoftware/alarmdecoder"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d6a8cd140d803ec3750c24df6f845ba8"

SRC_URI[sha256sum] = "61cad87c1fe2d8dda599844c081d43a5ada691eae0485b3307e856a48b5e3a65"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-pyserial (>=2.7)"

PYPI_PACKAGE = "alarmdecoder"
