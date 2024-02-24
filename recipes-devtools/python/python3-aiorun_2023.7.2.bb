SUMMARY = "A "run" function for asyncio-based apps that does all the boilerplate."
HOMEPAGE = "https://github.com/cjrh/aiorun"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

SRC_URI += "file://0001-update-flit-dependency.patch"
SRC_URI[sha256sum] = "95e689dc1b263aaf4556ef8fa73ccae68f38ba0f1c1017fe196ef7da244031f9"

inherit pypi python_flit_core

PYPI_PACKAGE = "aiorun"

RDEPENDS:${PN} += "\
	${PYTHON_PN}-core (>= 3.7) \
"
