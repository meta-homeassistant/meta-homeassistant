SUMMARY = "Python client for the Swisscom Internet-Box"
DESCRIPTION = "Async Python client for the Swisscom Internet-Box local API (/ws \
    endpoint)."
HOMEPAGE = "https://github.com/anatosun/python-swisscom-internet-box"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c45776f9a9d01241daa92ba4b171ed18"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1b5fe15b68d1e882960274aa717a8aea9516f6f18c971c04d4cef9c380420eec"
SRC_URI += "file://run-ptest"

inherit pypi python_setuptools_build_meta ptest

RDEPENDS:${PN} += "\
    python3-aiohttp \
"
