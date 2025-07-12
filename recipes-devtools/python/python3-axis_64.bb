SUMMARY = "Python library enabling easy communication with Axis devices and its metadatastream"
HOMEPAGE = "https://github.com/Kane610/axis"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=78a6a0bb7d76993abedec7510368fb0e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Relax-setuptools-requirement.patch \
           file://0002-relax-wheel-req.patch \
           "
SRC_URI[sha256sum] = "12a70f61faec1599baad1b7a5ba8b182eea7c5e0ec8f0ca071e268b9759c8c7f"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-httpx (>=0.27.2) \
    python3-orjson (>=3.10.12) \
    python3-packaging (>=24.2) \
    python3-xmltodict (>=0.14.2) \
"
