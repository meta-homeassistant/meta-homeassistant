DESCRIPTION = "Python library for using AWS Cognito. With support for SRP."
HOMEPAGE = "https://github.com/pvizeli/pycognito"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit pypi setuptools3

SRC_URI[sha256sum] = "ff46fe3682ead8eb727bd5107c36a28ccef0950a13c7f4bab0cb59aa38cbabda"

RDEPENDS:${PN} = "\
	python3-boto3 (>=1.10.49) \
	python3-requests (>=2.22.0) \
	python3-envs (>=1.3) \
	python3-pyjwt (>=2.8.0) \
	python3-python-jose-cryptography (>=3.2.0) \
"
