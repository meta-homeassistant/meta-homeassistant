SUMMARY = "Python library enabling easy communication with Axis devices and its metadatastream"
HOMEPAGE = "https://github.com/Kane610/axis"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=78a6a0bb7d76993abedec7510368fb0e"

SRC_URI += "file://0001-Adjust-min-version-of-wheel-and-setuptools.patch"
SRC_URI[sha256sum] = "3283e433c9f0c42b69ff6119a5462b1940dc5bb56a9eca807d27fc4c84feaacd"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-httpx (>=0.27.0) \
    python3-orjson (>=3.10.0) \
    python3-packaging (>=24.0) \
    python3-xmltodict (=0.13.0) \
"
