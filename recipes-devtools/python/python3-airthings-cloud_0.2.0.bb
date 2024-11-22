SUMMARY = "A python3 library to communicate with Airthings devices"
HOMEPAGE = "https://github.com/Danielhiversen/pyAirthings"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2736a6a8b58491968000c6e0130f0471"

SRC_URI[sha256sum] = "26a7850f840736eeb6ac36c6314582e214eff584975f34f57572733a7ba1da8c"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.0.6) \
    python3-async-timeout (>=3.0.0) \
"

PYPI_PACKAGE = "airthings_cloud"
