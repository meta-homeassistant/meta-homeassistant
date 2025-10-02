SUMMARY = "Interface to eSterownik.pl eCoal water boiler controller."
HOMEPAGE = "https://github.com/matkor/ecoaliface"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

DEPENDS = "python3-requests-native"
SRC_URI[sha256sum] = "6753be2e4ab5b08a63933d0de20e05094cd3c39d55e1f631954560fb6b19fda7"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "ecoaliface"
