SUMMARY = "A python API wrapper for Epion Air senor data"
HOMEPAGE = "https://github.com/devenzo-com/epion_python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6eccc347956b08c9ce3bcb689b62e33c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "87ea99e2ae67676f1bb81e8d7b0fa48a53402eb84734a12ff489be8b86adfe13"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-docopt python3-pytz python3-requests"

PYPI_PACKAGE = "epion"
