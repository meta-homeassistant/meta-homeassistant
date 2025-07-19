SUMMARY = "A client library for Apple TV and AirPlay devices"
HOMEPAGE = "https://pyatv.dev"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=7f8955c41f09c20ef7074b6b2b1390ba"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Make-PEP517-compliant.patch"
SRC_URI[sha256sum] = "4a25944fd82edcc353f2b2b08aecd6b5fc053d18c956b4d58addc51d598209e6"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.8.3) \
    python3-async-timeout (>=4.0.2) \
    python3-chacha20poly1305-reuseable (>=0.13.2) \
    python3-cryptography (>=44.0.1) \
    python3-ifaddr (>=0.1.7) \
    python3-miniaudio (>=1.45) \
    python3-protobuf (>=6.31.1) \
    python3-pydantic (>=1.10.10) \
    python3-requests (>=2.30.0) \
    python3-srptools (>=0.2.0) \
    python3-tabulate (>=0.9.0) \
    python3-tinytag (>=1.10.0) \
    python3-zeroconf (>=0.129.0) \
"

PYPI_PACKAGE = "pyatv"
