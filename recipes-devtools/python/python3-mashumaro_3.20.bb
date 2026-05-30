SUMMARY = "Fast serialization library on top of dataclasses"
HOMEPAGE = "https://github.com/Fatal1ty/mashumaro"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e7bdee652937974f23d94be386c358bd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/Fatal1ty/mashumaro.git;protocol=https;branch=master"
SRCREV = "822dfec5f158adcc3415ad735f0af2be273e5699"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-typing-extensions (>=4.1.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-msgpack \
    python3-orjson \
    python3-pyyaml \
    python3-tomli-w \
    python3-ciso8601 \
    python3-tzdata \
    python3-pendulum \
"
