SUMMARY = "Python wrapper for zwave-js-server"
HOMEPAGE = "https://github.com/home-assistant-libs/zwave-js-server-python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "243160a2bfd4fce45458e73e26ad171a179e67b311b812fca303322eca4d4229"

inherit pypi python_setuptools_build_meta


RDEPENDS:${PN} = "\
    python3-aiohttp (>3) \
    python3-pydantic (>=2.0.0) \
"
