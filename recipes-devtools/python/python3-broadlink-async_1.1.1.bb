SUMMARY = "Python API for controlling Broadlink devices"
DESCRIPTION = "A Python module and CLI for controlling Broadlink devices locally."
HOMEPAGE = "https://github.com/DAB-LABS/broadlink-async"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=41e038530f86b1b37b29ec7c9c4a7218"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "31d2809ed35b98cad1b332e3b0375458fb369081594c46ea85c9969e48a28fa2"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-cryptography \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
