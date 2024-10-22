SUMMARY = "Asynchronous Python client for Internet Printing Protocol (IPP)"
HOMEPAGE = "https://github.com/ctalkington/python-ipp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a8a03ceb18c4f191643ef270d79452c"

SRC_URI[sha256sum] = "88a4cf7acbeecfbf2a7c658b33858b7006c1c6ec7643fc418576a59ba2c5bdec"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-awesomeversion (>=21.10.1) \
    python3-backoff (>=2.2.0) \
    python3-deepmerge (>=1.1.0) \
    python3-core (>=3.9) \
    python3-yarl (>=1.6.0) \
"
