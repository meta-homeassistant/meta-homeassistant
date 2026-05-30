SUMMARY = "Electra Smart Python Integration."
HOMEPAGE = "https://github.com/jafar-atili/pyelectra/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

PYPI_SRC_URI = "git://github.com/jafar-atili/pyElectra;protocol=https;branch=main"
SRCREV = "e5cf8af7bc8f8a42d7b43883ec4264d7253994bc"

inherit pypi python_setuptools_build_meta

S = "${UNPACKDIR}/python3-pyelectra-${PV}"

RDEPENDS:${PN} += "\
    python3-aiohttp \
"
