SUMMARY = "Validate_email verify if an email address is valid and really exists."
HOMEPAGE = "http://github.com/syrusakbary/validate_email"
LICENSE = "LGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e08048833151d81fcf63810d6fe0b40c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "784719dc5f780be319cdd185dc85dd93afebdb6ebb943811bc4c7c5f9c72aeaf"

inherit pypi setuptools3

PYPI_PACKAGE = "validate_email"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
