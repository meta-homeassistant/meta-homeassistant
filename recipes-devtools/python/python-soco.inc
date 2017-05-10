SUMMARY = "SoCo (Sonos Controller) is a simple library to control Sonos speakers."
HOMEPAGE = "https://github.com/SoCo/SoCo"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=07b0e2ca9ac77cd65cd4edf2e13367ea"

inherit pypi

SRC_URI[md5sum] = "85ee9c8d5ec63cb0bd0f85a974bfda4f"
SRC_URI[sha256sum] = "17fc9a6ce747b8fc1811e67450533c3393e63dd6ffe38cff703d9bfc276836f6"

RDEPENDS_${PN} = "${PYTHON_PN}-requests"

BBCLASSEXTEND = "native"

# Make clean requires sphinx which we don't have
CLEANBROKEN = "1"
