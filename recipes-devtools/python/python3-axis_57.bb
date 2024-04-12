SUMMARY = "Python library enabling easy communication with Axis devices and its metadatastream"
HOMEPAGE = "https://github.com/Kane610/axis"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=78a6a0bb7d76993abedec7510368fb0e"

SRC_URI += "file://0001-Adjust-min-version-of-wheel-and-setuptools.patch"
SRC_URI[sha256sum] = "abd90936d4b9b4e971dc87b63c4571233f685557a79a9790c0783bed45112fc7"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-httpx (>=0.27.0) \
    python3-orjson (>=3.9.15) \
    python3-packaging (>=24.0) \
    python3-xmltodict (=0.13.0) \
"
