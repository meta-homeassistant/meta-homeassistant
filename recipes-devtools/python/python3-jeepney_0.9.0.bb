SUMMARY = ""
HOMEPAGE = "https://gitlab.com/takluyver/jeepney"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aad69c93f605003e3342b174d9b0708c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "cf0e9e845622b81e4a28df94c40345400256ec608d0e55bb8a3feaa9163f5732"

inherit pypi python_flit_core

PYPI_PACKAGE = "jeepney"

BBCLASSEXTEND = "native nativesdk"
