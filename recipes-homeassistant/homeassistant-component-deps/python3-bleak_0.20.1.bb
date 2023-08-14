SUMMARY = "A cross platform Bluetooth Low Energy Client for Python using asyncio"
HOMEPAGE = "https://github.com/hbldh/bleak"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bcbc2069a86cba1b5e47253679f66ed7"

SRC_URI[sha256sum] = "db599f5f100e252e9cdd4020c8657daca0371a3c697e87432abc702f3774cb4c"

inherit pypi python_setuptools_build_meta python_poetry_core

# Upstream typing-extensions version = 4.5
RDEPENDS:${PN} = "\
    ${PYTHON_PN}-async-timeout (>=3.0.0) \
    ${PYTHON_PN}-typing-extensions (>=4.2.0) \
    ${PYTHON_PN}-dbus-fast (>=1.83.0) \
"
