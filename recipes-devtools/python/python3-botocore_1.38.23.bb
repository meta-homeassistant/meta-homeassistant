DESCRIPTION = "Low-level, data-driven core of boto 3."
HOMEPAGE = "https://github.com/boto/botocore"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2ee41112a44fe7014dce33e26468ba93"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "29685c91050a870c3809238dc5da1ac65a48a3a20b4bca46b6057dcb6b39c72a"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-dateutil (>=2.1) \
    python3-jmespath (>=0.7.1) \
    python3-urllib3 (>=1.25.4) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-xdist \
"
