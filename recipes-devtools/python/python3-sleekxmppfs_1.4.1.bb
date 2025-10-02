SUMMARY = "A fork of SleekXMPP with TLS cert validation disabled, intended only to be used with the sucks project"
HOMEPAGE = "http://github.com/aszymanik/SleekXMPP"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c6599bc24bdf4c484690f251e6eeb237"

SRC_URI[sha256sum] = "af34edada840e6798e8f1aad063669dc3358075b19bd1662cdafc5e3c33858d9"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} = "python3-dnspython python3-pyasn1 python3-pyasn1-modules"

PYPI_PACKAGE = "sleekxmppfs"
