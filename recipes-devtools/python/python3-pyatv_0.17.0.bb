SUMMARY = "A client library for Apple TV and AirPlay devices"
HOMEPAGE = "https://pyatv.dev"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=7f8955c41f09c20ef7074b6b2b1390ba"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Converts-the-duplicate-update-test-to-pytest.mark.as.patch \
           file://0002-Fixes-the-shared-RAOP-TXT-fixture-name-so-it-matches.patch \
           file://0003-Removes-the-unused-event_loop-fixture-parameter-from.patch \
           file://0004-Removes-the-unused-event_loop-fixture-parameter-from.patch \
           "
SRC_URI[sha256sum] = "3408bfb442d1676ee4cde4d71d7715d3083e577a088be2ce9d96b86d0e0adec5"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += " \
    python3-aiohttp (>=3.8.3) \
    python3-chacha20poly1305-reuseable (>=0.13.2) \
    python3-cryptography (>=44.0.1) \
    python3-ifaddr (>=0.1.7) \
    python3-miniaudio (>=1.45) \
    python3-protobuf (>=6.31.1) \
    python3-pydantic (>=2.0.0) \
    python3-requests (>=2.30.0) \
    python3-srptools (>=0.2.0) \
    python3-tabulate (>=0.9.0) \
    python3-tinytag (>=1.10.0) \
    python3-zeroconf (>=0.129.0) \
"

RDEPENDS:${PN}-ptest += " \
    python3-deepdiff \
    python3-pyfakefs \
    python3-pytest-asyncio \
    python3-pytest-httpserver \
    python3-pytest-xdist \
"
