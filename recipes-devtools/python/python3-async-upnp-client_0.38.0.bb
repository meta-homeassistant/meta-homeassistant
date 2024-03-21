SUMMARY = "Async UPnP Client for Python"
HOMEPAGE = "https://github.com/StevenLooman/async_upnp_client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi setuptools3

PYPI_ARCHIVE_NAME = "async_upnp_client-${PV}.${PYPI_PACKAGE_EXT}"

S = "${WORKDIR}/async_upnp_client-${PV}"

SRC_URI[sha256sum] = "a7b6b45f4fb39ce988a6e0420ee5ed3ef1d34fb18254d96a239557ea3c1f7487"

RDEPENDS:${PN} = "\
	python3-core (>=3.8) \
	python3-async-timeout (>=3.0.0) \
	python3-aiohttp (>=3.9.1) \
	python3-python-didl-lite (=1.4.0) \
	python3-defusedxml (>=0.6.0) \
	python3-voluptuous (>=0.12.1) \
"
