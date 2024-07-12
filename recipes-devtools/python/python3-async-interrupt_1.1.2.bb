SUMMARY = "Context manager to raise an exception when a future is done"
HOMEPAGE = "https://github.com/bdraco/async_interrupt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"

SRC_URI[sha256sum] = "7a67c229d3d337e8db852cfe3c7e3012930a39eb4a4b30c036452a6f278d08f1"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "\
    python3-core (>=3.9) \
"

PYPI_PACKAGE = "async_interrupt"
