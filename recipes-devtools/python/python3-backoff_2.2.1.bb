SUMMARY = "Python library providing function decorators for configurable backoff and retry"
HOMEPAGE = "https://github.com/litl/backoff"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=11aa62344867e52ff1061aeb075eaa42"

SRC_URI[md5sum] = "b91bb50f190d683e166b9cdf13252493"
SRC_URI[sha256sum] = "03f829f5bb1923180821643f8753b0502c3b682293992485b0eef2807afa5cba"

inherit pypi python_setuptools_build_meta python_poetry_core
