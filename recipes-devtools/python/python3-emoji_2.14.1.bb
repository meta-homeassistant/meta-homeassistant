SUMMARY = "Emoji for Python"
HOMEPAGE = "https://github.com/carpedm20/emoji/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f1ce6ea8cc2d4e84e717e050278ca26b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/carpedm20/emoji.git;protocol=https;branch=master"
SRCREV = "08c5cc4789d924ad4215e2fb2ee8f0b19a0d421f"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "python3-typing-extensions"

do_install_ptest:append() {
    cp -r ${S}/utils ${D}${PTEST_PATH}/
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
