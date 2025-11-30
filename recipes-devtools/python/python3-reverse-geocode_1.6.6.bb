SUMMARY = "Reverse geocode the given latitude / longitude"
HOMEPAGE = "https://github.com/richardpenman/reverse_geocode/"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=f0a3e4a2554ebb89c046c93d45d8e4bc"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "14165815816cc639dd74eb660a74e464aeebcd1d0814de74a897d62071c99f2a"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-numpy python3-scipy"

PYPI_PACKAGE = "reverse_geocode"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
