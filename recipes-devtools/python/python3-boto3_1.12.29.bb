DESCRIPTION = "AWS SDK for Python"
HOMEPAGE = "https://github.com/boto/boto3"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

inherit pypi setuptools3

SRC_URI[md5sum] = "9ec881a10da7c4e56f7af015acf782ce"
SRC_URI[sha256sum] = "f31e10348909dd4dbe0e75ecd695a78c13dc4b49712cf90048a9e0ae80a4a84d"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-botocore (>=1.15.29) \
    ${PYTHON_PN}-jmespath (>=0.7.1) \
    ${PYTHON_PN}-s3transfer (>=0.2.0) \
"
