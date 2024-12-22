SUMMARY = "Standard library aifc redistribution. "dead battery"."
HOMEPAGE = "https://github.com/youknowone/python-deadlib"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4e3cd541391435e0a82da0f9f489e85f"

SRC_URI[sha256sum] = "64e249c7cb4b3daf2fdba4e95721f811bde8bdfc43ad9f936589b7bb2fae2e43"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-audioop-lts \
    python3-standard-chunk \
"

PYPI_PACKAGE = "standard_aifc"
