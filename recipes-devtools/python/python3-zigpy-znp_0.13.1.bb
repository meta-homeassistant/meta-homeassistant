SUMMARY = "A library for zigpy which communicates with TI ZNP radios"
HOMEPAGE = "https://github.com/zigpy/zigpy-znp"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI += "file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "31f20feec96df32a0cb7cdd64f3864f1ac72fc6363087caa7ef52fa61ab7fee1"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "zigpy_znp"
RDEPENDS:${PN} = "\
    python3-async-timeout \
    python3-coloredlogs \
    python3-jsonschema \
    python3-voluptuous \
    python3-zigpy (>=0.70.0) \
"
