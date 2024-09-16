SUMMARY = "Context manager to raise an exception when a future is done"
HOMEPAGE = "https://github.com/bdraco/async_interrupt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"

SRC_URI[sha256sum] = "d147559e2478501ad45ea43f52df23b246456715a7cb96e1aebdb4b71aed43d5"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "\
    python3-core (>=3.9) \
"

PYPI_PACKAGE = "async_interrupt"
