SUMMARY = "Asynchronous Implementation of the Frontier Silicon API"
HOMEPAGE = "https://github.com/zhelev/python-afsapi.git"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "24d9be9cab648e8f8bcf8ff8362310a8eb4c7ee85408b14322daa21e6471115e"

DEPENDS += "python3-hatch-vcs-native"

inherit pypi python_hatchling

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9) \
    python3-defusedxml (>=0.7.1) \
"
