SUMMARY = "Python library enabling easy communication with Axis devices and its metadatastream"
HOMEPAGE = "https://github.com/Kane610/axis"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=78a6a0bb7d76993abedec7510368fb0e"

SRC_URI[sha256sum] = "512ddfdf0e010b7cf45a25b9a3a9be458d3f2ad3dc73e4c8f407ea4f850612d2"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-async-timeout (>=4.0.2) \
    python3-attrs (>=23.1.0) \
    python3-httpx (>=0.24.0) \
    python3-orjson (>=3.8.10) \
    python3-packaging (>=23.1) \
    python3-xmltodict (=0.13.0) \
"
