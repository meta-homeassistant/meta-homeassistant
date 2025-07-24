SUMMARY = "Async Python package for the Aseko Pool Live API"
HOMEPAGE = "https://github.com/milanmeu/aioaseko"
LICENSE = "LGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "210dbb715a46a0cad25e2f7b5d5f38c44b2090618b2f46be97c36198df82283f"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-gql \
    python3-apischema \
"

PYPI_PACKAGE = "aioaseko"
