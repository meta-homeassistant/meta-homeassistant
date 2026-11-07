SUMMARY = "A python library to control CoolMasterNet HVAC bridges over asyncio."
HOMEPAGE = "https://github.com/OnFreund/pycoolmasternet-async"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5eb8d5cb3b379636f6e868cdcc75d0cf"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "33031dd1328bb0a87cd8fa731fbbb4c63b946ba5e1f379ad1d68df704e07433d"

inherit pypi python_setuptools_build_meta

DEPENDS += "python3-setuptools-scm-native"
