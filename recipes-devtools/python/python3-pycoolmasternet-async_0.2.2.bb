SUMMARY = "A python library to control CoolMasterNet HVAC bridges over asyncio."
HOMEPAGE = "https://github.com/OnFreund/pycoolmasternet-async"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5eb8d5cb3b379636f6e868cdcc75d0cf"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "dac518bbd132642d7e58419f1da19c0c8968683ca3e050dc203c59d098e6e3ea"

inherit pypi setuptools3

PYPI_PACKAGE = "pycoolmasternet_async"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
