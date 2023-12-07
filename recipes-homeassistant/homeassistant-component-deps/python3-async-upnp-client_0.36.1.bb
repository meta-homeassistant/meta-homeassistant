SUMMARY = "Async UPnP Client for Python"
HOMEPAGE = "https://github.com/StevenLooman/async_upnp_client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi setuptools3

PYPI_ARCHIVE_NAME = "async_upnp_client-${PV}.${PYPI_PACKAGE_EXT}"

S = "${WORKDIR}/async_upnp_client-${PV}"

SRC_URI[sha256sum] = "9033f9620a1d19121d85f0e90e8df6abb642fa01a56f26bc86bdcd24583c1a7d"

RDEPENDS:${PN} = "\
	${PYTHON_PN}-core (>=3.8) \
	${PYTHON_PN}-async-timeout (>=3.0.0) \
	${PYTHON_PN}-aiohttp (>=3.8.1) \
	${PYTHON_PN}-python-didl-lite (=1.3.2) \
	${PYTHON_PN}-defusedxml (>=0.6.0) \
	${PYTHON_PN}-voluptuous (>=0.12.1) \
"
