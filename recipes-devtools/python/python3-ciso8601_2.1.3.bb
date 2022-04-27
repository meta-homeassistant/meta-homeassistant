HOMEPAGE = "https://www./"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit pypi setuptools3

SRC_URI[md5sum] = "5d6434ad5ba5d54167aaa96b3503d81e"
SRC_URI[sha256sum] = "bdbb5b366058b1c87735603b23060962c439ac9be66f1ae91e8c7dbd7d59e262"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-pytz (>=2019.03) \
"
