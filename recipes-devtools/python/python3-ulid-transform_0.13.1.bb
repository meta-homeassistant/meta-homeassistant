SUMMARY = "Convert Voluptuous schemas to dictionaries so they can be serialized."
HOMEPAGE = "https://github.com/bdraco/ulid-transform"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"

inherit python_poetry_core pypi

DEPENDS += "\
    python3-cython-native \
"

PYPI_PACKAGE = "ulid_transform"

SRC_URI[sha256sum] = "48dbd3daf814cedea340734ac85c30e78fd26a1b29ce18a310d3ba4426b98b6a"
