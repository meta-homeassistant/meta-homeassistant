SUMMARY = "Python library enabling easy communication with Axis devices and its metadatastream"
HOMEPAGE = "https://github.com/Kane610/axis"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=78a6a0bb7d76993abedec7510368fb0e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/Kane610/axis;protocol=https;tag=v${PV};branch=master \
           file://0001-relax-build-reqs.patch \
           "
SRCREV = "92678a37d79de6da9a94358f61e3d86f991ed139"

DEPENDS += "python3-wheel-native"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.12) \
    python3-faust-cchardet (>=2.1.18) \
    python3-orjson (>=3.9) \
    python3-packaging (>=23) \
    python3-tomli (>=2.0) \
    python3-tomli-w (>=1.0) \
    python3-xmltodict (>=0.13.0) \
    python3-zeroconf (>=0.150.0) \
"

RDEPENDS:${PN}-ptest:append = "\
    python3-pytest-aiohttp \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-respx \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}

