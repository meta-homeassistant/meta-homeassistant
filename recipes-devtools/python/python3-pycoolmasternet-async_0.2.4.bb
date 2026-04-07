SUMMARY = "A python library to control CoolMasterNet HVAC bridges over asyncio."
HOMEPAGE = "https://github.com/OnFreund/pycoolmasternet-async"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5eb8d5cb3b379636f6e868cdcc75d0cf"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0fe314b26deeb59aefda292a8f459297a5292d9038448041fdb48bbe22ad09f5"

inherit pypi setuptools3

PYPI_PACKAGE = "pycoolmasternet_async"
