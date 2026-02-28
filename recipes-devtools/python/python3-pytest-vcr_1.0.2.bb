SUMMARY = "Plugin for managing VCR.py cassettes"
HOMEPAGE = "https://github.com/ktosiek/pytest-vcr"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9e82f2e59209b93d98fefcb1062c1a5e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "23ee51b75abbcc43d926272773aae4f39f93aceb75ed56852d0bf618f92e1896"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-pytest python3-vcrpy"

PYPI_PACKAGE = "pytest-vcr"
