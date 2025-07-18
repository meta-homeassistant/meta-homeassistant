SUMMARY = "Cloudflare DNS API Python Wrapper"
HOMEPAGE = "https://github.com/ludeeus/pycfdns"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=94261a91c8669997e0a75acb84e440ef"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "bddfb66ea169c298fdf6052cd14aeccd4c5776efe113e66f72108901574423af"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp \
"

PYPI_PACKAGE = "pycfdns"
