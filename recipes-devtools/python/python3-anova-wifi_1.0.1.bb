SUMMARY = "A package to get read only data from Anova precision cookers with wifi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6dff558e55968609815741eb8d5e5e6d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f4b42fd2c5f145df49edb5036fe6516915c46d12cd975b358f40bcfe22e6d3c0"

inherit pypi python_poetry_core


RDEPENDS:${PN} = "python3-aiohttp (>=3.9.3)"
