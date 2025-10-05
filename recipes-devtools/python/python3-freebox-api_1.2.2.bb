SUMMARY = "Provides asynchronous authentication and access to Freebox servers"
HOMEPAGE = "https://github.com/hacf-fr/freebox-api"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=94367b65e8cc78bc24fe46e640568dee"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a5e30098a2f9ef59cdda6ae837fc703ca472453e55807f2ec63aab0f2409d548"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3) \
"

PYPI_PACKAGE = "freebox_api"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
