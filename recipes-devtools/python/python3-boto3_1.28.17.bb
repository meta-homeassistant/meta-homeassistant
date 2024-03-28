DESCRIPTION = "AWS SDK for Python"
HOMEPAGE = "https://github.com/boto/boto3"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

inherit pypi setuptools3

SRC_URI[sha256sum] = "90f7cfb5e1821af95b1fc084bc50e6c47fa3edc99f32de1a2591faa0c546bea7"

RDEPENDS:${PN} = "\
    python3-botocore (>=1.31.17) \
    python3-jmespath (>=0.7.1) \
    python3-s3transfer (>=0.6.0) \
"
