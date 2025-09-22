SUMMARY = "Async UPnP Client for Python"
HOMEPAGE = "https://github.com/StevenLooman/async_upnp_client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f4eda51018051de136d3b3742e9a7a40"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI[sha256sum] = "f5814b6c24ab97ba0f0940eb20624355880ae45e2a87dadbfa7b8482eccf8d3b"

PYPI_PACKAGE = "async_upnp_client"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.1) \
    python3-async-timeout (>=3.0.0) \
    python3-core (>=3.8) \
    python3-defusedxml (>=0.6.0) \
    python3-python-didl-lite (=1.4.0) \
    python3-voluptuous (>=0.15.2) \
"

RDEPENDS:${PN}-ptest:append = " \
    python3-pytest-aiohttp \
    python3-pytest-asyncio \
"
