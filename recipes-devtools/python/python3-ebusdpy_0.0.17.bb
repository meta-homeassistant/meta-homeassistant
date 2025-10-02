SUMMARY = "eBusd python integration library"
HOMEPAGE = "https://github.com/CrazYoshi/ebusdpy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=31;endline=31;md5=c3f07aaf829a0fa3e19b2ed383f777ad"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b7a3bf7ce06b26e0d8a4256790bfa1533caa32818a163e5460da03e84c6290d3"

inherit pypi setuptools3

PYPI_PACKAGE = "ebusdpy"
