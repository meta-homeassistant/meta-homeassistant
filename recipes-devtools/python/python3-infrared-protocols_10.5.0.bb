SUMMARY = "Library to decode and encode infrared signals"
DESCRIPTION = "Python package to decode and encode infrared signals for use in \
    Home Assistant."
HOMEPAGE = "https://github.com/home-assistant-libs/infrared-protocols"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a07b308b0a0080746c4fff7e2a8b6e57"

# The PyPI sdist does not contain the test suite.
SRC_URI = "git://github.com/home-assistant-libs/infrared-protocols.git;protocol=https;branch=main;tag=${PV}"
SRC_URI += "file://0001-relax-setuptools-requirement.patch"
SRCREV = "bc79639682dafe0f89bc08ff5bb967ec4a4ba302"

inherit python_setuptools_build_meta ptest-python-pytest

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}

# The release workflow sets the version; the tagged pyproject.toml says 0.0.0.
do_configure:prepend() {
    sed -i 's/^version      = "0.0.0"/version      = "${PV}"/' ${S}/pyproject.toml
}
