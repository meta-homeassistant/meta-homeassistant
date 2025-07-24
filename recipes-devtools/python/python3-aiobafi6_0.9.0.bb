SUMMARY = "Big Ass Fans i6/Haiku protocol asynchronous Python library"
HOMEPAGE = "https://github.com/jfroy/aiobafi6"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e7df7137170f3840630acd765590c0e51adce2fa78e7b9b24f97e5080977c3b3"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiobafi6"
RDEPENDS:${PN} = "\
    python3-zeroconf (>=0.38) \
    python3-protobuf (>=3.20) \
"
