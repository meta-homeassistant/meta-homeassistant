SUMMARY = "Tools to implement Secure Remote Password (SRP) authentication"
HOMEPAGE = "https://github.com/idlesign/srptools"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ab61e61d6fda178bef6ff39ab2f571c2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7fa4337256a1542e8f5bb4bed19e1d9aea98fe5ff9baf76693342a1dd6ac7c96"

inherit pypi setuptools3

PYPI_PACKAGE = "srptools"

RDEPENDS:${PN} = "\
    python3-six \
"
