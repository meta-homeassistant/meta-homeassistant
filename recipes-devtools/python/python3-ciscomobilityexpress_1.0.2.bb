SUMMARY = "Module to interact with Cisco Mobility Express APIs to fetch connected devices."
HOMEPAGE = "https://github.com/fbradyirl/ciscomobilityexpress"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8b47b131eba433d1fdfaa0420b7d7177"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d8787245598e8371a83baa4db1df949d8a942c43f13454fa26ee3b09c3ccafc0"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-requests (>=2.21.0)"

PYPI_PACKAGE = "ciscomobilityexpress"
