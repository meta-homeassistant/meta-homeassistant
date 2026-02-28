SUMMARY = "UUID version 7, generating time-sorted UUIDs with 200ns time resolution and 48 bits of randomness"
HOMEPAGE = "https://github.com/stevesimmons/uuid7"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5176c4bd63d8d4cc59d4fa0cc36fa116"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8c57aa32ee7456d3cc68c95c4530bc571646defac01895cfc73545449894a63c"

inherit pypi setuptools3 ptest-python-pytest

PYPI_PACKAGE = "uuid7"
