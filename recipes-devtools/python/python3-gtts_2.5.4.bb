SUMMARY = "Python library and CLI tool to interface with Google Translate's text-to-speech API"
HOMEPAGE = "https://github.com/pndurette/gTTS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3f9e2857e297482569ee81ba5205ce4b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "gTTS"
PYPI_SRC_URI = "git://github.com/pndurette/gTTS;protocol=https;branch=main"

SRCREV = "5007fa454d296ab77249ab706af4bc299e500401"

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-click \
    python3-requests \
    python3-six \
"
