DESCRIPTION = "An Amazon S3 Transfer Manager"
HOMEPAGE = "https://github.com/boto/s3transfer/"
AUTHOR = "Amazon Web Services"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[sha256sum] = "2ed07d3866f523cc561bf4a00fc5535827981b117dd7876f036b0c1aca42c947"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-botocore (>=1.12.36) \
"
