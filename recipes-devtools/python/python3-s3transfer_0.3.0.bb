DESCRIPTION = "An Amazon S3 Transfer Manager"
HOMEPAGE = "https://github.com/boto/s3transfer/"
AUTHOR = "Amazon Web Services"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b1e01b26bacfc2232046c90a330332b3"

SRC_URI[md5sum] = "5d87acf131bde3ece012d6d6ea489759"
SRC_URI[sha256sum] = "e3343ae0f371781c17590cf06cb818a54484fbac9a65a5be7603a39b0a6d7b31"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-multiprocessing \
"
