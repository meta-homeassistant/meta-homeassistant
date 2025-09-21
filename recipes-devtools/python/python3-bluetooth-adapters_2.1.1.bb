SUMMARY = "Tools to enumerate and find Bluetooth Adapters"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-adapters"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f289e0f08814f74252a28862f488283680584744430d7eac45820f9c20ba041a"

inherit pypi python_poetry_core ptest-python-pytest

PYPI_PACKAGE = "bluetooth_adapters"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-aiooui (>=0.1.1) \
    python3-bleak (>=0.21.1) \
    python3-core (>3.9) \
    python3-uart-devices (>=0.1.0) \
"
