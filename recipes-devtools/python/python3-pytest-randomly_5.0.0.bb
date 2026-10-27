SUMMARY = "Pytest plugin to randomly order tests and control random.seed."
HOMEPAGE = "https://github.com/pytest-dev/pytest-randomly"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dd54c94e040946267bc2300dbc7d7e6d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-build-deps.patch"
SRC_URI[sha256sum] = "e9c575a5873ef168ddbe340ed9e97ce9edb4492ccc821e4b2ac6bb1f0ed515d2"

inherit pypi python_uv_build

RDEPENDS:${PN} = "python3-pytest"
