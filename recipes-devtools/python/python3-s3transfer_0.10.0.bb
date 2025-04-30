DESCRIPTION = "An Amazon S3 Transfer Manager"
HOMEPAGE = "https://github.com/boto/s3transfer/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d0c8bbf672d5eebbe4e57945e23b972d963f07d82f661cabf678a5c88831595b"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-botocore (>=1.33.2) \
"
