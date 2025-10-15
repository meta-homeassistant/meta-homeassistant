SUMMARY = "An easy safelist-based HTML-sanitizing tool."
HOMEPAGE = "https://github.com/mozilla/bleach"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=adea50d072dac455e5a50a518e2d01aa"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "123e894118b8a599fd80d3ec1a6d4cc7ce4e5882b1317a7e1ba69b56e95f991f"

inherit pypi setuptools3 ptest-python-pytest

PACKAGECONFIG ?= "css"
PACKAGECONFIG[css] = ",,,python3-tinycss2"

RDEPENDS:${PN} += "python3-webencodings bash"

PYPI_PACKAGE = "bleach"
