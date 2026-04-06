SUMMARY = "WSGI (PEP 333) Reference Library"
HOMEPAGE = "http://cheeseshop.python.org/pypi/wsgiref"
LICENSE = "PSF-2.0 | ZPL-2.1"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=d933a991eaea0e21162565f1736b2fa2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-remove-ez-setup.patch"
SRC_URI[sha256sum] = "c7e610c800957046c04c8014aab8cce8f0b9f0495c8cd349e57c1f7cabf40e79"

inherit pypi setuptools3

PYPI_PACKAGE = "wsgiref"
PYPI_PACKAGE_EXT = "zip"
