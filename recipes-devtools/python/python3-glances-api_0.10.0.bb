SUMMARY = "Python API for interacting with Glances"
HOMEPAGE = "https://github.com/home-assistant-ecosystem/python-glances-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2755c7445ae030bc6acadf229a953ad0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1781cee2a76a8476e9313e2e176d0212a1c0477f75ef2c88e748e8ceab8383c6"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-httpx (>=0.23) \
"
