SUMMARY = "Access your OS root certificates with utmost ease"
HOMEPAGE = "https://github.com/jawah/wassima"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a7facf5510e6e0e24fb2d332516341df"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7c7fa67161ebe0c0ffbbc4c648186de80124f62474682b57c3ac60520d5c471b"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "wassima"
