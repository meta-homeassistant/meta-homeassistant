SUMMARY = "Octoprint API wrapper"
HOMEPAGE = "https://github.com/rfleming71/pyoctoprintapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=62642aee8c8da4a6a3dcbdafbb9c5b79"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3a262ba57d4628b79cbe00e67caa14a61f889661368e99f3719dfc88423b650c"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-aiohttp \
"
