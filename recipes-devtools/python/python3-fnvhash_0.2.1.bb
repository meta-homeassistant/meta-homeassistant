SUMMARY = "Pure Python FNV hash implementation"
HOMEPAGE = "https://github.com/znerol/py-fnvhash"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.rst;beginline=29;endline=29;md5=68b329da9893e34099c7d8ad5cb9c940"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "python3-setuptools-scm-native"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "0c7e885f44c8f06de07f442befebc590ee9ca0cc88846681f608496284ce9cd5"

