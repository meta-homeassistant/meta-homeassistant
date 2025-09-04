SUMMARY = "Coinbase API client library"
HOMEPAGE = "https://github.com/coinbase/coinbase-python/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c7afd4d0ab1af73a33dd9bb77357a345"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "65ced674f3ecc0b51db1fdad83d7574c35fb82787ebae81479dc7fb6f40fdb54"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-pycryptodome (>=3.4.11) \
    python3-requests (>=2.5) \
    python3-six (>=1.9) \
"

PYPI_PACKAGE = "coinbase"
