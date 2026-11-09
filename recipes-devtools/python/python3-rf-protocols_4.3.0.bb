SUMMARY = "Library to decode and encode radio frequency signals"
DESCRIPTION = "Python package to decode and encode radio frequency signals for \
    use in Home Assistant."
HOMEPAGE = "https://github.com/home-assistant-libs/rf-protocols"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a07b308b0a0080746c4fff7e2a8b6e57"

SRC_URI += "file://0001-relax-setuptools-requirement.patch"
SRC_URI[sha256sum] = "a08c0f50708c7da417b3e49da7a3f9d90a116c4da178562c680243e28ac2002e"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
