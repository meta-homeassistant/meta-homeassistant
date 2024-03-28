DESCRIPTION = "An Amazon S3 Transfer Manager"
HOMEPAGE = "https://github.com/boto/s3transfer/"
AUTHOR = "Amazon Web Services"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[sha256sum] = "368ac6876a9e9ed91f6bc86581e319be08188dc60d50e0d56308ed5765446283"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-botocore (>=1.33.2) \
"
