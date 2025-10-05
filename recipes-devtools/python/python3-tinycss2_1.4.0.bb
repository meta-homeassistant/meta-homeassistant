SUMMARY = "A tiny CSS parser"
HOMEPAGE = "https://www.courtbouillon.org/tinycss2"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1d072d7e30e34f33f8ae956ada04fa2c"

SRC_URI[sha256sum] = "10c0972f6fc0fbee87c3edb76549357415e94548c1ae10ebccdea16fb404a9b7"

inherit pypi python_flit_core ptest-python-pytest

RDEPENDS:${PN} += "python3-webencodings (>=0.4)"

PYPI_PACKAGE = "tinycss2"
