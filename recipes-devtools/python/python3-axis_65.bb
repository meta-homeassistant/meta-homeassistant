SUMMARY = "Python library enabling easy communication with Axis devices and its metadatastream"
HOMEPAGE = "https://github.com/Kane610/axis"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=78a6a0bb7d76993abedec7510368fb0e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7ddfab537ea080abc663304cb1135d8a8388f0ecfea7054ff31236b98fa24701"
SRC_URI = "git://github.com/Kane610/axis;protocol=https;tag=v${PV};branch=master \
           file://0001-add-compat-for-pytest-asyncio.patch \
           "

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-faust-cchardet \
    python3-httpx (>=0.27.2) \
    python3-orjson (>=3.10.12) \
    python3-packaging (>=24.2) \
    python3-xmltodict (>=0.14.2) \
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

