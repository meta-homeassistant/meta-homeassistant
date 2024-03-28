DESCRIPTION = "Python library for using AWS Cognito. With support for SRP."
HOMEPAGE = "https://github.com/pvizeli/pycognito"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit pypi setuptools3

SRC_URI[sha256sum] = "3843cfff56969f7c4b0b2fd499877941d0bf33e39c4541dc896c2b83bef5db24"

RDEPENDS:${PN} = "\
	python3-boto3 (>=1.10.49) \
	python3-requests (>=2.22.0) \
	python3-envs (>=1.3) \
	python3-python-jose-cryptography (>=3.2.0) \
"
