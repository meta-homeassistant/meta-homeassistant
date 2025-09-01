SUMMARY = "Enhance the standard unittest package with features for testing asyncio libraries"
HOMEPAGE = "https://github.com/Martiusweb/asynctest/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=5883ca2cb50c78a60976cdab69424b3c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c27862842d15d83e6a34eb0b2866c323880eb3a75e4485b079ea11748fd77fac"

inherit pypi setuptools3 ptest-python-pytest

PYPI_PACKAGE = "asynctest"
