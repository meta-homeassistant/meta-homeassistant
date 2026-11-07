SUMMARY = "An HTTP client for controlling a Bryant Evolution HVAC system"
HOMEPAGE = "https://github.com/danielsmyers/evolutionhttp"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44cc82feb2b87bfb8bcca45b68b40e6d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "561598864ad95540eed48e996536654d484d7e999adbdb446012e84fbc417753"
SRC_URI += "file://run-ptest"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-pyserial \
    python3-pyserial-asyncio-fast \
"

RDEPENDS:${PN}-ptest += "\
    python3-aiofiles \
    python3-mock \
"

# This package tests directly against the source so make it available
do_install_ptest:append() {
    cd ${S}
    find src -type f -exec install -D -m 0644 {} ${D}${PTEST_PATH}/{} \;
}
