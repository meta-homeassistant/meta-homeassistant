SUMMARY = "A series of convenience functions to make basic image processing functions such as translation, rotation, resizing, skeletonization, displaying Matplotlib images, sorting contours, detecting edges, and much more easier with OpenCV and both Python 2.7 and Python 3."
HOMEPAGE = "https://github.com/jrosebr1/imutils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "03827a9fca8b5c540305c0844a62591cf35a0caec199cb0f2f0a4a0fb15d8f24"

inherit pypi setuptools3

PYPI_PACKAGE = "imutils"
