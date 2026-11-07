SUMMARY = "Provides asynchronous authentication and access to Freebox servers"
HOMEPAGE = "https://github.com/hacf-fr/freebox-api"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=94367b65e8cc78bc24fe46e640568dee"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4499889cb32a734f7dd64c7256420041593421ead4a122d27a8cabcd88909433"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3) \
"
