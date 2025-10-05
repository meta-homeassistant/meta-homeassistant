SUMMARY = "setuptools_scm plugin for git archives"
HOMEPAGE = "https://github.com/Changaco/setuptools_scm_git_archive/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=838c366f69b72c5df05c96dff79b35f2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-remove-setup-requirement.patch"
SRC_URI[sha256sum] = "c418bc77b3974d3ac65f268f058f23e01dc5f991f2233128b0e16a69de227b09"

DEPENDS = "python3-setuptools-scm-native"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-core python3-pytest"

PYPI_PACKAGE = "setuptools_scm_git_archive"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

BBCLASSEXTEND = "native nativesdk"
