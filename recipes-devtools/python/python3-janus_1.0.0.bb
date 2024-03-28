SUMMARY = "Thread-safe asyncio-aware queue for Python"
HOMEPAGE = "https://github.com/aio-libs/janus"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=23878c357ebb4c8ce1109be365043349"

SRC_URI[md5sum] = "2d8c0b884c14f18fc5223858eb16461e"
SRC_URI[sha256sum] = "df976f2cdcfb034b147a2d51edfc34ff6bfb12d4e2643d3ad0e10de058cb1612"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-typing-extensions (>=3.7.4.3) \
"
