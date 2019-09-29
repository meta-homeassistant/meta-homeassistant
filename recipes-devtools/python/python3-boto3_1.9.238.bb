DESCRIPTION = "AWS SDK for Python"
HOMEPAGE = "https://github.com/boto/boto3"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

inherit pypi setuptools3

SRC_URI[md5sum] = "30c69938ed51dcddfe8e6b28c149c38f"
SRC_URI[sha256sum] = "2fc1c407a5ab08cfcf54eb4171d85c523bd27019ab890de257d018af2770f71d"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-botocore (>=1.12.238) \
    ${PYTHON_PN}-jmespath (>=0.7.1) \
    ${PYTHON_PN}-s3transfer (>=0.2.0) \
"
