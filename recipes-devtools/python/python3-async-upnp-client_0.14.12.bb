LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi setuptools3

SRC_URI = "https://files.pythonhosted.org/packages/source/a/async-upnp-client/async_upnp_client-0.14.12.tar.gz"

S = "${WORKDIR}/async_upnp_client-${PV}"

SRC_URI[md5sum] = "5d1bae23edb2269992ad42040438616c"
SRC_URI[sha256sum] = "99f4f371d20c418940c21f79290fabd4e5b6eb37460b7eee12aaa502bd3ee1b9"

RDEPENDS:${PN} = "\
	${PYTHON_PN}-async-timeout (>=3.0.0) \
	${PYTHON_PN}-python-didl-lite (>=1.2.4) \
	${PYTHON_PN}-defusedxml (>=0.5.0) \
	${PYTHON_PN}-voluptuous (>=0.11.1) \
"
