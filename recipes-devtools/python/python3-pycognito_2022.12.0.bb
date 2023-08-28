DESCRIPTION = "Python library for using AWS Cognito. With support for SRP."
HOMEPAGE = "https://github.com/pvizeli/pycognito"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit pypi setuptools3

SRC_URI[sha256sum] = "49cc07420f3862942ee7e6903633d7a12f7dd12c3bd2e7546beff5815513d92f"

RDEPENDS:${PN} = "\
	${PYTHON_PN}-boto3 (>=1.10.49) \
	${PYTHON_PN}-requests (>=2.22.0) \
	${PYTHON_PN}-envs (>=1.3) \
	${PYTHON_PN}-python-jose-cryptography (>=3.2.0) \
"
