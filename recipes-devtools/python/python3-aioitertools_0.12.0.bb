SUMMARY = "itertools and builtins for AsyncIO and mixed iterables"
HOMEPAGE = "https://github.com/omnilib/aioitertools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f0c422eaa1f23d09f8203dc0af3e2d54"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c2a9055b4fbb7705f561b9d86053e8af5d10cc845d22c32008c43490b2d8dd6b"

inherit pypi python_flit_core

PYPI_PACKAGE = "aioitertools"
