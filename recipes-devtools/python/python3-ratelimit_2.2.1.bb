SUMMARY = "API rate limit decorator"
HOMEPAGE = "https://github.com/tomasbasham/ratelimit"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=79a571aea266911f7ab2e20dd50bd096"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "af8a9b64b821529aca09ebaf6d8d279100d766f19e90b5059ac6a718ca6dee42"

inherit pypi setuptools3

PYPI_PACKAGE = "ratelimit"
