SUMMARY = "pyaprilaire is a library to interact with Aprilaire thermostats."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4b880a0c262aeacbae1722b00b7de60f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3610747a4776799a0be3d0b73fa0811c96362e7f06fbc3a0e5c8f88f30739ce9"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "pyaprilaire"
RDEPENDS:${PN} = "python3-crc"
