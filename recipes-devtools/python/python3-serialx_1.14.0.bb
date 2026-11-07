SUMMARY = "Serial library with native sync and async support for Windows, Linux, macOS, and other platforms"
HOMEPAGE = "https://github.com/puddly/serialx"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "508fbc83290b2c368cc3cc034bc2a30fa083d1bdcfae6755a1175f6ec14c8af1"

DEPENDS = "python3-setuptools-scm-native"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-typing-extensions \
"

RDEPENDS:${PN}-ptest:append = " \
    python3-psutil \
    python3-pytest-asyncio \
    python3-pytest-timeout \
    python3-pytest-xdist \
    python3-pytest-cov \
    socat \
"

do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
