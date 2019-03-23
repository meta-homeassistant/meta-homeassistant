SUMMARY = "cryptography is a package which provides cryptographic recipes and primitives to Python developers."
HOMEPAGE = "https://github.com/pyca/cryptography"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=097f805837700cfac572ac274cd38124"

PYPI_PACKAGE = "cryptography"

inherit pypi

SRC_URI[md5sum] = "401cc8268f89496643da3f7a48eb4e8e"
SRC_URI[sha256sum] = "26c821cbeb683facb966045e2064303029d572a87ee69ca5a1bf54bf55f93ca6"

DEPENDS += "${PYTHON_PN}-cffi-native"
