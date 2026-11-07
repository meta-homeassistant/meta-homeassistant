SUMMARY = "Python 3 wrapper for playing media via gstreamer"
HOMEPAGE = "https://github.com/happyleavesaoc/gstreamer-player/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4e5239d86abdb7cdf33633402d2724008b6e6dc41d20c0054bf5fbe5c9f859c6"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-mutagen (>=1.36.2)"
