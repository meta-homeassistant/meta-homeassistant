SUMMARY = "Octoprint API wrapper"
HOMEPAGE = "https://github.com/rfleming71/pyoctoprintapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=62642aee8c8da4a6a3dcbdafbb9c5b79"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "933e2195efe91d110253cf7650c7ac630e4f26b3456fede098765fbd9cdb2945"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-aiohttp \
"
