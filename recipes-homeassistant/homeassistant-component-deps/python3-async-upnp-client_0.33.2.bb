SUMMARY = "Async UPnP Client for Python"
HOMEPAGE = "https://github.com/StevenLooman/async_upnp_client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi setuptools3

PYPI_ARCHIVE_NAME = "async_upnp_client-${PV}.${PYPI_PACKAGE_EXT}"

S = "${WORKDIR}/async_upnp_client-${PV}"

SRC_URI[sha256sum] = "33ca50ec49e12175b01f43dd75fb80507613937fcd18a999fbd87b03a45a26d3"

RDEPENDS:${PN} = "\
	${PYTHON_PN}-async-timeout (>=3.0.0) \
	${PYTHON_PN}-aiohttp (>=3.7.4) \
	${PYTHON_PN}-python-didl-lite (=1.3.2) \
	${PYTHON_PN}-defusedxml (>=0.6.0) \
	${PYTHON_PN}-voluptuous (>=0.12.1) \
"
