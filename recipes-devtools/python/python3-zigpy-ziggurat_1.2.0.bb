SUMMARY = "Zigpy radio library for the Ziggurat server"
DESCRIPTION = "A Zigpy radio library for Ziggurat, a Zigbee stack implemented in \
    Rust."
HOMEPAGE = "https://github.com/zigpy/zigpy-ziggurat"
LICENSE = "Apache-2.0"
# The project ships no license file.
LIC_FILES_CHKSUM = "file://pyproject.toml;beginline=14;endline=14;md5=b785a1f4e1ff6e5da7331358b80f813b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# The PyPI sdist lacks tests/common.py, which the test suite imports.
SRC_URI = "git://github.com/zigpy/zigpy-ziggurat.git;protocol=https;branch=dev;tag=v${PV} \
           file://0001-pyproject.toml-allow-setuptools-git-versioning-3.patch \
           "
SRCREV = "fa1edc5113bad343d07c03ef2649a8947b82e4d0"

inherit python_setuptools_build_meta ptest-python-pytest

DEPENDS += "python3-setuptools-git-versioning-native python3-wheel-native"

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-aiospinel \
    python3-statistics \
    python3-zigpy \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-timeout \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
