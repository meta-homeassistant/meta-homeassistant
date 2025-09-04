SUMMARY = "Microsoft Authentication Library extensions (MSAL EX) provides a persistence API that can save your data on disk, encrypted on Windows, macOS and Linux. Concurrent data access will be coordinated by a file lock mechanism."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=27e94c0280987ab296b0b8dd02ab9fe5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c5b0fd10f65ef62b5f1d62f4251d51cbcaf003fcedae8c91b040a488614be1a4"

inherit pypi setuptools3

#PACKAGECONFIG ?= "portalocker"
PACKAGECONFIG[portalocker] = ",,,python3-portalocker"

RDEPENDS:${PN} += "python3-msal (>=1.29)"

PYPI_PACKAGE = "msal_extensions"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
