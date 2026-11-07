SUMMARY = "Python 3 asyncio package for interacting with Control4 systems"
HOMEPAGE = "https://github.com/lawtancool/pyControl4"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "49138f89ad61f7740127f50c3d1669d1fb399e54e7c7cc1971555d17cb7a86ac"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-python-socketio-v4 \
    python3-websocket-client \
    python3-xmltodict \
"
