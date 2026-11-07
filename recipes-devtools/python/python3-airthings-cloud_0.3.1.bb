SUMMARY = "A python3 library to communicate with Airthings devices"
HOMEPAGE = "https://github.com/Danielhiversen/pyAirthings"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2736a6a8b58491968000c6e0130f0471"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "70b5f2974258454ada289ad12fd31b82192f7ab09a11cd10e9c90ed8d7fbf73a"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.0.6) \
"
