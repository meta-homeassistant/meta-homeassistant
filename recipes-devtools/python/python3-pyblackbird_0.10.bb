SUMMARY = "Python API for talking to Monoprice Blackbird 4k 8x8 HDBaseT Matrix"
HOMEPAGE = "https://github.com/koolsb/pyblackbird"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b987cde240fbe5031bde4e50f2e15390"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "26a7006dba114ae51a4024f9e83df197e75e581d474c67964c0181af9e3bd3ea"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-serialx \
"
