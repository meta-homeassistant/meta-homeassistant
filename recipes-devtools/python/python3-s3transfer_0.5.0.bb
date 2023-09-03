DESCRIPTION = "An Amazon S3 Transfer Manager"
HOMEPAGE = "https://github.com/boto/s3transfer/"
AUTHOR = "Amazon Web Services"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b1e01b26bacfc2232046c90a330332b3"

SRC_URI[sha256sum] = "50ed823e1dc5868ad40c8dc92072f757aa0e653a192845c94a3b676f4a62da4c"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-botocore (>=1.12.36) \
"
