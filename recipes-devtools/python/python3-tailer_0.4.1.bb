SUMMARY = "Python tail is a simple implementation of GNU tail and head."
HOMEPAGE = "http://github.com/six8/pytailer"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b01821f3a3a668a9e65c9dc00de4151c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "78d60f23a1b8a2d32f400b3c8c06b01142ac7841b75d8a1efcb33515877ba531"

inherit pypi setuptools3

PYPI_PACKAGE = "tailer"
