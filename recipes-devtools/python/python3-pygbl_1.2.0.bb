SUMMARY = "Parser for Silicon Labs GBL and EBL firmware images"
DESCRIPTION = "A parser for the EBL and GBL (v3 and v4) firmware image formats \
    used by the Silicon Labs Gecko bootloader."
HOMEPAGE = "https://github.com/zigpy/pygbl"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[sha256sum] = "fd3ec9afbb4fffaae602d3ac2401da378f1868eb53f7dc22203f93dea6f5d3b5"

DEPENDS += "python3-setuptools-scm-native"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "python3-pyelftools"

# tests/files holds Silicon Labs firmware images (ARM ELF) as test data.
# The package itself is pure Python, so there is nothing to strip.
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INSANE_SKIP:${PN}-ptest += "arch"

RDEPENDS:${PN}-ptest += "\
    python3-cryptography \
    python3-lz4 \
    python3-pytest-timeout \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
