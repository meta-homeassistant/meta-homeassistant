SUMMARY = "Convert Voluptuous schemas to dictionaries so they can be serialized."
HOMEPAGE = "https://github.com/bdraco/ulid-transform"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"

inherit python_poetry_core pypi

DEPENDS += "\
    python3-cython-native \
"

PYPI_PACKAGE = "ulid_transform"

SRC_URI[sha256sum] = "9b710f6adb93a7620910bce385c7e977a234ab321443ec3bc1e48ae931f1e5d4"
