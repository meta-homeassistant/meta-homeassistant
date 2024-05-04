SUMMARY = "Python library enabling easy communication with Axis devices and its metadatastream"
HOMEPAGE = "https://github.com/Kane610/axis"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=78a6a0bb7d76993abedec7510368fb0e"

SRC_URI += "file://0001-Adjust-min-version-of-wheel-and-setuptools.patch"
SRC_URI[sha256sum] = "538a3cf3e973ed99f8f7fb8d13205eadfceed363e8eaa942418246039ac231d4"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-httpx (>=0.27.0) \
    python3-orjson (>=3.10.0) \
    python3-packaging (>=24.0) \
    python3-xmltodict (=0.13.0) \
"
