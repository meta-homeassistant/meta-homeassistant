SUMMARY = "Pytest Snapshot Test Utility"
HOMEPAGE = "https://github.com/tophat/syrupy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=48672cd576fa10fcb05f80eb40fff161"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3282fe963fa5d4d3e47231b16d1d4d0f4523705e8199eeb99a22a1bc9f5942f2"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "python3-pytest"
