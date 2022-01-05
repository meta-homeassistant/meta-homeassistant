LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit pypi setuptools3

SRC_URI[md5sum] = "fce49db800fa7d17786346aba083e2b7"
SRC_URI[sha256sum] = "38f47bed399967329d06a784081b427e94a5055ad7487875fb8af8b58d4db611"

RDEPENDS:${PN} = "\
	${PYTHON_PN}-aiohttp (>=3.0.0) \
"
