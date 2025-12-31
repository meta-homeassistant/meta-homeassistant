SUMMARY = "pytest plugin to check source code with pylint"
HOMEPAGE = "https://github.com/carsongee/pytest-pylint"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d61df3e9aee8868f79f946b265930398"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "88764b8e1d5cfa18809248e0ccc2fc05035f08c35f0b0222ddcfea1c3c4e553e"

DEPENDS = "python3-pytest-runner-native"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-pylint python3-pytest"

PYPI_PACKAGE = "pytest-pylint"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
