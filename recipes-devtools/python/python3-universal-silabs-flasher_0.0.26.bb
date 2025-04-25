SUMMARY = "Tool to flash firmware onto any Silicon Labs radio running EmberZNet, CPC multi-PAN, or just a bare Gecko Bootloader"
HOMEPAGE = "https://github.com/NabuCasa/universal-silabs-flasher"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI[sha256sum] = "481eef9ad48ee92d1345dbbdd295475f16731064654b71ea2a8b1d3d24ec1027"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "universal_silabs_flasher"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-bellows (>=0.42.0) \
    python3-click (>=8.0.0) \
    python3-coloredlogs \
    python3-crc \
    python3-gpiod \
    python3-pyserial-asyncio-fast \
    python3-typing-extensions \
    python3-zigpy (>=0.70.0) \
"
