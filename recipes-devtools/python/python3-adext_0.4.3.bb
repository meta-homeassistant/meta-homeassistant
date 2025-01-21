SUMMARY = "AlarmDecoder extended"
HOMEPAGE = "https://github.com/ajschmidt8/adext"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=31c8623bc439370f4fd7f41e531e161f"

SRC_URI[sha256sum] = "bcc2abf8cc2a47dbd4af572a21adbe8020a41d182f64f583507909cc83f7a954"

inherit pypi setuptools3

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += "python3-alarmdecoder"

PYPI_PACKAGE = "adext"
