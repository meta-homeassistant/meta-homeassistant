SUMMARY = "Asynchronous Python client for Internet Printing Protocol (IPP)"
HOMEPAGE = "https://github.com/ctalkington/python-ipp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a8a03ceb18c4f191643ef270d79452c"

SRC_URI[sha256sum] = "764d14ab0adde2a40cc30439bcbda13d728001f9004467670d830c6d39f4aa9d"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-awesomeversion (>=21.10.1) \
    python3-backoff (>=2.2.0) \
    python3-deepmerge (>=1.1.0) \
    python3-core (>=3.9) \
    python3-yarl (>=1.6.0) \
"
