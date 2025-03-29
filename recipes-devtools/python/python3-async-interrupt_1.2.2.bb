SUMMARY = "Context manager to raise an exception when a future is done"
HOMEPAGE = "https://github.com/bdraco/async_interrupt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "be4331a029b8625777905376a6dc1370984c8c810f30b79703f3ee039d262bf7"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "\
    python3-core (>=3.9) \
"

PYPI_PACKAGE = "async_interrupt"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
