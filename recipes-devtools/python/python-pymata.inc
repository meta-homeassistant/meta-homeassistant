SUMMARY = "A Python Protocol Abstraction Library For Arduino Firmata"
HOMEPAGE = "https://github.com/MrYsLab/PyMata"
LICENSE = "GPL-3.0"
#TODO: https://github.com/MrYsLab/PyMata/pull/33
LIC_FILES_CHKSUM = "file://setup.cfg;md5=7afce96631527fbc985d5ea969ce2f83"

inherit pypi

PYPI_PACKAGE = "PyMata"

SRC_URI[md5sum] = "bc13015b54160c9e6750a3a0af18ccf7"
SRC_URI[sha256sum] = "7c239efc7cfe6313e5116c1abf865c2a2b10e24b60742fb4df904523cc4e5af4"

RDEPENDS_${PN} = "${PYTHON_PN}-pyserial"
