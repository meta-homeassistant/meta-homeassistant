SUMMARY = "a simple python3 library for the Bouygues BBox Routeur API"
HOMEPAGE = "https://github.com/HydrelioxGitHub/pybbox"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=eca0f6a234f50cdd6f61eb35da7836c7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "35bd556c38600127e9b2bd6872cbe2108478446a14704b5c32d012f4153c3a67"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-netaddr python3-requests"

PYPI_PACKAGE = "pybbox"
PYPI_PACKAGE_EXT = "zip"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
