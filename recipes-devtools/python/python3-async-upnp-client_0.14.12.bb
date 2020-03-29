LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit pypi setuptools3

SRC_URI = "https://files.pythonhosted.org/packages/source/a/async-upnp-client/async_upnp_client-0.14.12.tar.gz"

S = "${WORKDIR}/async_upnp_client-${PV}"

SRC_URI[md5sum] = "5d1bae23edb2269992ad42040438616c"
SRC_URI[sha256sum] = "99f4f371d20c418940c21f79290fabd4e5b6eb37460b7eee12aaa502bd3ee1b9"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-async-timeout (>=3.0.0) \
	${PYTHON_PN}-python-didl-lite (>=1.2.4) \
	${PYTHON_PN}-defusedxml (>=0.5.0) \
	${PYTHON_PN}-voluptuous (>=0.11.1) \
"
