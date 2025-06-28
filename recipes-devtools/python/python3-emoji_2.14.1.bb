SUMMARY = "Emoji for Python"
HOMEPAGE = "https://github.com/carpedm20/emoji/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4799dd49db977b572103afc6d8df904e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/carpedm20/emoji.git;protocol=https;branch=master"
SRC_URI[sha256sum] = "f8c50043d79a2c1410ebfae833ae1868d5941a67a6cd4d18377e2eb0bd79346b"
SRCREV = "257c6ae1a6414c84b37339d6ef88a6dda41ecdbd"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "python3-typing-extensions"

do_install_ptest:append() {
    cp -r ${S}/utils ${D}${PTEST_PATH}/
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
