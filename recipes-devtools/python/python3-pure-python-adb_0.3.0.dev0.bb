SUMMARY = "Pure python implementation of the adb client"
HOMEPAGE = "https://github.com/Swind/pure-python-adb"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=10abb65256392e3f6889e706d0f753b2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi setuptools3 ptest-python-pytest

SRC_URI[sha256sum] = "0ecc89d780160cfe03260ba26df2c471a05263b2cad0318363573ee8043fb94d"

PACKAGECONFIG ?= "async"
PACKAGECONFIG[async] = ",,,python3-aiofiles"

PTEST_PYTEST_DIR = "test_async"
