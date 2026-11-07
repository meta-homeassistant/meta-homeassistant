SUMMARY = "An aiohttp-based client for Genius Hub systems"
HOMEPAGE = "https://github.com/manzanotti/geniushub-client"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d969eabee386a82b26ce6c7391754ae6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1d7282b099d8acdeab632857229144ed71767172eb1c9ec19fe549111bbba81a"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp (>=3.7.4)"

# setup.py takes the version from the GitHub release ref
export GITHUB_REF_NAME = "${PV}"
