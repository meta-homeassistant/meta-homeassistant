SUMMARY = "A wrapper for the Blue Current websocket api"
HOMEPAGE = "https://github.com/bluecurrent/HomeAssistantAPI"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3a544f696922fca917d7cabdd279be0f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d96396f25b0d12513af45d1191c3310d54b68b939b23b712ae6cf7d536f0278a"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "bluecurrent_api"

RDEPENDS:${PN} = "\
    python3-websockets (>=15.0) \
"

RDEPENDS:${PN}-ptest:append = "\
    ${PN} \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-mock \
    python3-types-pytz \
    python3-zoneinfo \
    python3-tzdata \
"

# This package tests directly against the source so make it available
do_install_ptest:append() {
    cp -rf ${S}/src ${D}${PTEST_PATH}/
}

# Ensure pytest can import the 'src' top-level package by adding
# a .pth that points at the ptest path (so `import src.bluecurrent_api` works)
do_install_ptest:append() {
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}
    echo "${PTEST_PATH}" > ${D}${PYTHON_SITEPACKAGES_DIR}/${PN}-ptest.pth
}