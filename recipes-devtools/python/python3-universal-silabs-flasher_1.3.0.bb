SUMMARY = "Tool to flash firmware onto any Silicon Labs radio running EmberZNet, CPC multi-PAN, or just a bare Gecko Bootloader"
HOMEPAGE = "https://github.com/NabuCasa/universal-silabs-flasher"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI += "file://0001-relax-build-requirement.patch"
SRC_URI[sha256sum] = "3153ce3096829fe231b73045ac834830d20a64fbf406609ecbac384f88281515"

inherit pypi python_setuptools_build_meta ptest-python-pytest


RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-aiospinel (>=1.3.0) \
    python3-bellows (>=0.49.0) \
    python3-colorlog \
    python3-crc \
    python3-gpiod \
    python3-pygbl (>=1.0.0) \
    python3-tqdm \
    python3-typing-extensions \
    python3-zigpy (>=1.3.0) \
"
