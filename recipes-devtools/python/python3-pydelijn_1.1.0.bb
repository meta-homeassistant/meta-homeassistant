SUMMARY = "Get realtime info on stop passages of De Lijn (api.delijn.be)"
HOMEPAGE = "https://github.com/bollewolle/pydelijn"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=32c93e2fafe287fb3aa326cd7ca7c86a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c7206ada1de2a546ab923097abd1886d8edb86c7fdef6f5a4301dd7b7a392ba8"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.6.2) \
    python3-async-timeout (>=4.0.0) \
    python3-pytz (>=2020.1) \
"

PYPI_PACKAGE = "pydelijn"
