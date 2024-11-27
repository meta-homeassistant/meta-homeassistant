SUMMARY = "An api allowing control of AC state (temperature, on/off, mode) of an Airtouch 4 controller locally over TCP"
HOMEPAGE = "https://github.com/LonePurpleWolf/airtouch4pyapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=463c4da11a61b51771c05939b4976a10"

SRC_URI[sha256sum] = "fdb3d17a467f0ef34a9ce7e04e38de41ba661ff65c1523fe1e406c8cbe3dce75"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-numpy"

PYPI_PACKAGE = "airtouch4pyapi"
