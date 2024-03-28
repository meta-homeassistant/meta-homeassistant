SUMMARY = "Python library and CLI tool to interface with Google Translate's text-to-speech API"
HOMEPAGE = "https://github.com/pndurette/gTTS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9adeade917617bdadfcd128d5647b498"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "gTTS"
PYPI_SRC_URI = "git://github.com/pndurette/gTTS;protocol=https;branch=main"

SRCREV = "d57db26b60286e7f684d32e305757d5587005eee"

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-click \
    python3-requests \
    python3-six \
"
