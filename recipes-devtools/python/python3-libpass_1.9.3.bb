SUMMARY = "Fork of passlib, a comprehensive password hashing framework supporting over 30 schemes"
HOMEPAGE = "https://github.com/notypecheck/passlib"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c8449c5e10474d113ab787ed2753bafe \
                    file://docs/copyright.rst;md5=a3fc1f7974d36c77622a4a54129d4b6d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "7830b9323d9ba96a841ad698a8dec1d43a2b0b7f1c855c76772e7972c1c6d959"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "libpass"
