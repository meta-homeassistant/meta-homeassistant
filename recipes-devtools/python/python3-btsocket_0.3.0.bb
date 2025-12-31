SUMMARY = "Python library to interact with the Bluez Bluetooth Management API communicating with the kernel using a so-called Bluetooth Management sockets"
HOMEPAGE = "https://github.com/ukBaz/python-btsocket"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=363a8d5ecf81b0e022be8395c2a6986b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7ea495de0ff883f0d9f8eea59c72ca7fed492994df668fe476b84d814a147a0d"

inherit pypi python_setuptools_build_meta ptest-python-pytest
