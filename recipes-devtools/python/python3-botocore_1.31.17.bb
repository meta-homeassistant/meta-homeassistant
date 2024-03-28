DESCRIPTION = "Low-level, data-driven core of boto 3."
HOMEPAGE = "https://github.com/boto/botocore"
AUTHOR = "Amazon Web Services"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI[sha256sum] = "396459065dba4339eb4da4ec8b4e6599728eb89b7caaceea199e26f7d824a41c"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-jmespath \
    python3-dateutil \
    python3-docutils \
    python3-shell \
    python3-netserver \
    python3-email \
    python3-json \
    python3-numbers \
    python3-html \
    python3-urllib3 \
" 
