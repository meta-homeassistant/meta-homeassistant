LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit pypi setuptools3

SRC_URI[md5sum] = "cb3992e31bcebbb25861416b73809773"
SRC_URI[sha256sum] = "7325a2e850339c97bde23e923f7908be5f3453745d9ce8905a956f2f93c6127a"

SRC_URI += "file://0001-fix-build.patch"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-pbr (>=5.4.0) \
    "
