DESCRIPTION = "AWS SDK for Python"
HOMEPAGE = "https://github.com/boto/boto3"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

inherit pypi setuptools3

SRC_URI[sha256sum] = "739705b28e6b2329ea3b481ba801d439c296aaf176f7850729147ba99bbf8a9a"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-botocore (>=1.23.24) \
    ${PYTHON_PN}-jmespath (>=0.7.1) \
    ${PYTHON_PN}-s3transfer (>=0.5.0) \
"
