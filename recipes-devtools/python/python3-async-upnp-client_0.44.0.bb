SUMMARY = "Async UPnP Client for Python"
HOMEPAGE = "https://github.com/StevenLooman/async_upnp_client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f4eda51018051de136d3b3742e9a7a40"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit setuptools3 ptest-python-pytest

SRC_URI = "git://github.com/StevenLooman/async_upnp_client.git;protocol=https;branch=development"
SRCREV = "1bbeeb178f3cd69b387b43d1eb359aa2e45d347d"
SRC_URI[sha256sum] = "569b8e56e4ffae73f1acb45d2f70ff65a263f70b964d482081b82f5561cd8ab4"

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
