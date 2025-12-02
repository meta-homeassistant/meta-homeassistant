SUMMARY = "Query metadata from sdists / bdists / installed packages."
HOMEPAGE = "https://code.launchpad.net/~tseaver/pkginfo/trunk"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=6fc86b61c6077306ca1f5edc8edcc490"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5cd957824ac36f140260964eba3c6be6442a8359b8c48f4adf90210f33a04b7b"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
