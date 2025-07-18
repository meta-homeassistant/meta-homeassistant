SUMMARY = "High level Steam API implementation with low level reusable core"
HOMEPAGE = "https://github.com/Lagg/steamodd"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ef3f6fc5311c5eec09d029eb495537b7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "2761271135c37f65df807e0ee29a03eed1d90761128a2860196f0383ba7d44a0"

inherit pypi setuptools3 ptest-python-pytest

PYPI_PACKAGE = "steamodd"
