SUMMARY = "Python library and CLI tool to interface with Google Translate's text-to-speech API"
HOMEPAGE = "https://github.com/pndurette/gTTS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9adeade917617bdadfcd128d5647b498"

SRC_URI[md5sum] = "fe3a2d18bc80c7c85fb899ac6bd39a52"
SRC_URI[sha256sum] = "e0b688ff777928afe280c3cf4d36bc7b794e93e86851b680d54ba2fb68e88456"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "gTTS"
PYPI_SRC_URI = "https://github.com/pndurette/gTTS/archive/refs/tags/v2.2.4.tar.gz"
