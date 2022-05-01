LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi setuptools3

PYPI_ARCHIVE_NAME = "async_upnp_client-${PV}.${PYPI_PACKAGE_EXT}"

S = "${WORKDIR}/async_upnp_client-${PV}"

SRC_URI[sha256sum] = "54ac8a7ce4b15eb3ae3c3f4c5b42a964c58414a187f280c19f67b4cc01771908"

RDEPENDS:${PN} = "\
	${PYTHON_PN}-async-timeout (>=3.0.0) \
	${PYTHON_PN}-python-didl-lite (>=1.2.4) \
	${PYTHON_PN}-defusedxml (>=0.5.0) \
	${PYTHON_PN}-voluptuous (>=0.11.1) \
"
