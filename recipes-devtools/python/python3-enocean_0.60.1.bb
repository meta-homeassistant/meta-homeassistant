SUMMARY = "EnOcean serial protocol implementation"
HOMEPAGE = "https://github.com/kipe/enocean"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c10a04732249c6efac3893a9f1a791e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "dba314dffd35ed05300a14056ef6b4e801260b233126edee9dc9107a2578c57c"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-beautifulsoup4 (>=4.3.2) \
    python3-enum-compat (>=0.0.2) \
    python3-pyserial (>=3.0) \
"

PYPI_PACKAGE = "enocean"
