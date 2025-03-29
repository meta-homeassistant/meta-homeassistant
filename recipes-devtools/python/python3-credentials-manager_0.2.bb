SUMMARY = "Simple credential management"
HOMEPAGE = "https://github.com/dreynolds/CredentialsManager"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=cced8b49901709fa7b9968bb88dac559"

SRC_URI[sha256sum] = "5536d3ba33d84f7c138fec1709d5349abfa0134a2d3706d9a84ded4dbcf03f58"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-keyring"

PYPI_PACKAGE = "credentials_manager"
