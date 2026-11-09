SUMMARY = "SRTP audio proxy for HomeKit camera streaming"
DESCRIPTION = "SRTP audio proxy that relays camera audio between FFmpeg and \
    HomeKit clients for HomeKit camera streaming."
HOMEPAGE = "https://pypi.org/project/homekit-audio-proxy"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3cbbe5fe7af54187f1080e658697103f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# The PyPI sdist lacks tests/conftest.py, which the tests import.
SRC_URI = "git://github.com/bdraco/homekit-audio-proxy.git;protocol=https;branch=main;tag=v${PV}"
SRCREV = "cbfb5312038db6bba0ac6ff8721ffc0c74fc33a4"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-cryptography \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-timeout \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
