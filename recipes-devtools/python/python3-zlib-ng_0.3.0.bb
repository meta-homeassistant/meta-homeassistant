SUMMARY = "Drop-in replacement for zlib and gzip modules using zlib-ng"
HOMEPAGE = "https://github.com/pycompression/python-zlib-ng"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=18130810ab035d8cac1d00602892f13d"

SRC_URI[sha256sum] = "f2d196b70c733a1e59f380f626fb68fe65aa6fe080a8aa5039c898e83367761d"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "python3-core"

PYPI_PACKAGE = "zlib-ng"
