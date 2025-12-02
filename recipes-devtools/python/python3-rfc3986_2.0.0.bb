SUMMARY = "Validating URI References per RFC 3986"
HOMEPAGE = "http://rfc3986.readthedocs.io"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=03731a0e7dbcb30cecdcec77cc93ec29"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "97aacf9dbd4bfd829baad6e6309fa6573aaf1be3f6fa735c8ab05e46cecb261c"

inherit pypi setuptools3 ptest-python-pytest

BBCLASSEXTEND = "native nativesdk"
