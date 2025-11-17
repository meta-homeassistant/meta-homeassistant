SUMMARY = "Python interface for the Gitter API"
HOMEPAGE = "https://github.com/MichaelYusko/GitterPy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=4bf5e4de9a4488dad6149fff3af29203"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9e667ab158eb1d12dfbd732bfdf62237e6b85a5cbced82b0011fa178ffec3641"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.13.0)"

