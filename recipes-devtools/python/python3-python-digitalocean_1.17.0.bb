SUMMARY = "digitalocean.com API to manage Droplets and Images"
HOMEPAGE = "https://github.com/koalalorenzo/python-digitalocean"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=bb3ca60759f3202f1ae42e3519cd06bc"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "107854fde1aafa21774e8053cf253b04173613c94531f75d5a039ad770562b24"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-jsonpickle python3-requests"

PYPI_PACKAGE = "python-digitalocean"
