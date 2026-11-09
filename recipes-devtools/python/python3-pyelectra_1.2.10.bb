SUMMARY = "Electra Smart Python Integration."
HOMEPAGE = "https://github.com/jafar-atili/pyelectra/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

PYPI_SRC_URI = "git://github.com/jafar-atili/pyElectra;protocol=https;branch=main;tag=${PV}"
SRCREV = "1f593f6c8c8e3f84772051ce5c1aed8093699400"

DEPENDS = "python3-wheel-native"

inherit pypi python_setuptools_build_meta

S = "${UNPACKDIR}/python3-pyelectra-${PV}"

RDEPENDS:${PN} += "\
    python3-aiohttp \
"
