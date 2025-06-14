SUMMARY = "A QR code generator written purely in Python with SVG, EPS, PNG and terminal output."
HOMEPAGE = "https://github.com/mnooner256/pyqrcode"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "fdbf7634733e56b72e27f9bce46e4550b75a3a2c420414035cae9d9d26b234d5"

inherit pypi setuptools3

PACKAGECONFIG ?= "png"
PACKAGECONFIG[png] = ",,,python3-pypng"

PYPI_PACKAGE = "PyQRCode"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
