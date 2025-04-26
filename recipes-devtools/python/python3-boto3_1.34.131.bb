DESCRIPTION = "AWS SDK for Python"
HOMEPAGE = "https://github.com/boto/boto3"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/boto/boto3.git;protocol=https;branch=master"
SRC_URI[sha256sum] = "0e966b8a475ecb06cc0846304454b8da2473d4c8198a45dfb2c5304871986883"
SRCREV = "fd8bccadc77b2ea53d786afcf77148955acf15aa"

inherit setuptools3 ptest-python-pytest

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-botocore (>=1.34.131) \
    python3-jmespath (>=0.7.1) \
    python3-s3transfer (>=0.10.0) \
"
