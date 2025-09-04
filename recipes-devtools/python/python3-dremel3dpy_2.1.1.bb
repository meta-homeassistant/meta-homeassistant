SUMMARY = "A Dremel 3D Printer Python Library running on Python 3"
HOMEPAGE = "https://github.com/godely/dremel3dpy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ecd52e9934a4b5c009bd5a99df195a96"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8a8670bdb74f84eda4635d13a86478dbb9915090546796e6a62595395f763a42"

DEPENDS = "\
    python3-numpy-native \
    python3-requests-native \
    python3-validators-native \
    python3-yarl-native \
"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-decorator (>=5.0) \
    python3-imageio (>=2.0) \
    python3-imutils (>=0.0) \
    python3-requests (>=2.0) \
    python3-tqdm (>=4.0) \
    python3-validators (>=0.0) \
    python3-yarl (>=1.0) \
"

PYPI_PACKAGE = "dremel3dpy"
