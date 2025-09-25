SUMMARY = "ISO 4217 currency data package for Python"
HOMEPAGE = "https://github.com/dahlia/iso4217"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=fcf18a5a416a5c26c83143d78b7608b5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f036bd5460f1d371f2df253e90be5032930c8f76512f3a02ecfa5ad1e9fb164b"

inherit pypi setuptools3

PYPI_PACKAGE = "iso4217"
