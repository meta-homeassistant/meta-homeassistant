SUMMARY = "Python API For Flick Electric in New Zealand"
HOMEPAGE = "https://github.com/ZephireNZ/PyFlick"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f5a86c43c7f97110f913adf6a7056b93"

DEPENDS = "python3-setuptools-scm-native"
SRC_URI[sha256sum] = "8ededb9fecab8d9828a93d15977e2a918819318b5548979a0925a1f5e2a97e4e"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.11.10) \
    python3-json-api-doc (>=0.15.0) \
    python3-dateutil (>=2.9.0) \
"
