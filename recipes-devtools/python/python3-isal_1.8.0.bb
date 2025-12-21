SUMMARY = "Faster zlib and gzip compatible compression and decompression by providing python bindings for the isa-l library."
HOMEPAGE = "https://github.com/pycompression/python-isal"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE;md5=18130810ab035d8cac1d00602892f13d "

DEPENDS = "python3-setuptools-scm-native nasm-native"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI += "file://0001-Ensure-build-paths-are-adjusted-for-a-yocto-environm.patch"
SRC_URI[sha256sum] = "124233e9a31a62030a07aafd48c26689561926f4e10417ed3ea46c211218f2b4"

RDEPENDS:${PN}-ptest += " \
    python3-tests \
"
