DESCRIPTION = "Python library for using AWS Cognito. With support for SRP."
HOMEPAGE = "https://github.com/pvizeli/pycognito"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit pypi setuptools3

SRC_URI[md5sum] = "eb7abcf4783ef9a42c26908ad42cb6cf"
SRC_URI[sha256sum] = "b5b229e46b9953eea482b7d5ea48c6307b1d50642e594e621f713d27d1f8d324"

RDEPENDS:${PN} = "\
	${PYTHON_PN}-boto3 (>=1.10.49) \
	${PYTHON_PN}-requests (>=2.22.0) \
	${PYTHON_PN}-envs (>=1.3) \
	${PYTHON_PN}-python-jose-cryptography (>=3.2.0) \
"
