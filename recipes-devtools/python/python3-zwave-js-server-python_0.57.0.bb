SUMMARY = "Python wrapper for zwave-js-server"
HOMEPAGE = "https://github.com/home-assistant-libs/zwave-js-server-python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "ece7bcd3a1b4143eec45066c5f6ae2818c833d17cc2636e3868bd3b89eec56d7"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "zwave_js_server_python"

RDEPENDS:${PN} = "\
    python3-aiohttp (>3) \
    python3-pydantic (>=1.10.0) \
"
