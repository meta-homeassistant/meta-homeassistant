SUMMARY = "A simple Python wheel builder for simple projects."
HOMEPAGE = "https://github.com/repo-helper/whey"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a484934fb535cddc2470eef202da5a2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-adjust-build-req.patch"
SRC_URI[sha256sum] = "97bd9f8dcceeb835e0fdc0e2a89eeba0d566e17f9abbed6ee0003c4b3b356cda"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "whey"

BBCLASSEXTEND = "native nativesdk"
