SUMMARY = "LTS Port of Python audioop"
HOMEPAGE = "https://github.com/AbstractUmbra/audioop"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fcf6b249c2641540219a727f35d8d2c2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "64d0c62d88e67b98a1a5e71987b7aa7b5bcffc7dcee65b635823dbdd0a8dbbd0"

inherit pypi python_setuptools_build_meta ptest-python-pytest
