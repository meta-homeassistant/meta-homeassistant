SUMMARY = "A powerful declarative symmetric parser/builder for binary data"
HOMEPAGE = "http://construct.readthedocs.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=202b39559c1c79fe4715ce81e9e0ac02"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4d2472f9684731e58cc9c56c463be63baa1447d674e0d66aeb5627b22f512c29"

inherit pypi setuptools3 ptest-python-pytest

PACKAGECONFIG ?= "extras"
PACKAGECONFIG[extras] = ",,,python3-arrow python3-cloudpickle python3-cryptography python3-lz4 python3-numpy python3-ruamel-yaml"


# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-compression python3-core python3-crypt python3-cryptography python3-debugger python3-misc python3-pickle"

PYPI_PACKAGE = "construct"
