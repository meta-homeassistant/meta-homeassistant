SUMMARY = "Convert Voluptuous schemas to dictionaries so they can be serialized."
HOMEPAGE = "https://github.com/bdraco/ulid-transform"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit python_poetry_core pypi cython

PYPI_PACKAGE = "ulid_transform"

SRC_URI[sha256sum] = "cef07d688483e7573b835423f242d0d6700d92429abc438c0941de61eacdf215"
