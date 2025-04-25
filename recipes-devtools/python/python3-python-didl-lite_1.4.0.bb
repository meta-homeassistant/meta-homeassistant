SUMMARY = "DIDL-Lite (Digital Item Declaration Language) tools for Python"
HOMEPAGE = "https://github.com/StevenLooman/python-didl-lite"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi setuptools3

SRC_URI[sha256sum] = "54585ad41bee6d34f00adbdaa3e00a56547c7b6930b6d4280b887437e6c6666e"

RDEPENDS:${PN} = "\
	python3-defusedxml (>=0.6.0) \
"
