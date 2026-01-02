SUMMARY = "Python API for Yale Access (formerly August) Smart Lock and Doorbell"
HOMEPAGE = "https://github.com/bdraco/yalexs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=61764be905fd8aa5707070c78f0aa894"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "637f19b7cbf30331ad9b36045a36e0ee14f7758736bfd5b893c3278b838b4ad5"

inherit pypi python_poetry_core

PYPI_PACKAGE = "yalexs"

RDEPENDS:${PN} = "\
    python3-ciso8601 (>=2.1.3) \
    python3-pyjwt (>=2.8.0) \
    python3-requests (>=2) \
    python3-dateutil (>=2.9.0) \
    python3-aiohttp (>=3.10.5) \
    python3-aiofiles (>=23) \
    python3-freenub (>=0.1.0) \
    python3-typing-extensions (>=4.5.0) \
    python3-socketio (>=5.0.0) \
    python3-propcache \
"
