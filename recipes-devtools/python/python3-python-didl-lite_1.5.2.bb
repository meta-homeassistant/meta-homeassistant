SUMMARY = "DIDL-Lite (Digital Item Declaration Language) tools for Python"
HOMEPAGE = "https://github.com/StevenLooman/python-didl-lite"
LICENSE = "Apache-2.0"
# The 1.5.x sdist lacks LICENSE.txt although pyproject.toml lists it
LIC_FILES_CHKSUM = "file://pyproject.toml;beginline=7;endline=7;md5=2507bd5f0713f05419cd2f22fa06fe62"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "1ec2b09309701745befca09b15427724d60e333c882e6504ab8b0d835e32524b"

RDEPENDS:${PN} = "\
	python3-defusedxml (>=0.6.0) \
"
