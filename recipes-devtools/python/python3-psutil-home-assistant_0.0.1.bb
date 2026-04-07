SUMMARY = "Wrapper of psutil that removes reliance on globals "
HOMEPAGE = "https://github.com/home-assistant-libs/psutil-home-assistant"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

PYPI_SRC_URI = "git://github.com/home-assistant-libs/psutil-home-assistant.git;protocol=https;branch=master"
SRCREV = "7a09bcf9773b528d8b9f33257839d7775704f1a4"

inherit pypi python_setuptools_build_meta ptest-python-pytest

S = "${UNPACKDIR}/python3-psutil-home-assistant-${PV}"

RDEPENDS:${PN} = "\
    python3-psutil \
"
