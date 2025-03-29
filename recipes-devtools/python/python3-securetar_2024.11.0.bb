SUMMARY = "Secure Tarfile library"
HOMEPAGE = "https://github.com/pvizeli/securetar"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "2191d8c8234777bba287a9b3e8a16cd3ec78fb52d092d1ef1b57d14c81d6838d"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-cryptography \
"
