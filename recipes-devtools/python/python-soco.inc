SUMMARY = "SoCo (Sonos Controller) is a simple library to control Sonos speakers."
HOMEPAGE = "https://github.com/SoCo/SoCo"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=07b0e2ca9ac77cd65cd4edf2e13367ea"

inherit pypi

SRC_URI[md5sum] = "701990416213d98b77452b1f81409b85"
SRC_URI[sha256sum] = "d666186f9c69db8b764c1101dba78621698a09eff6ee89d3f4152ea377184907"

RDEPENDS_${PN} = "${PYTHON_PN}-requests"

BBCLASSEXTEND = "native"

# Make clean requires sphinx which we don't have
CLEANBROKEN = "1"
