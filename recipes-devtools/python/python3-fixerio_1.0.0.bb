SUMMARY = "A Python client for Fixer.io"
HOMEPAGE = "https://github.com/amatellanes/fixerio"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a6e9d9ae9c7370bb7cbbd01aa5f5bdd1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/amatellanes/fixerio.git;branch=master;protocol=https"
SRCREV = "0890e0ee3d39a2a3a2396d934c32bc9ed5f4c974"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-requests (>=2.10.0)"
