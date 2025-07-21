SUMMARY = "Interface for ATEN-PE PDUs"
HOMEPAGE = "https://github.com/mtdcr/pductl"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5ec3b9007ec327cfbc677ee9ee55922f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "05c0b0e72e4b0748cba7d7513f466c00e6d3674ee44be87e1e6f0f6743705371"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-async-timeout (>=4.0.2) \
    python3-pysnmp (>=6.2.5) \
"

PYPI_PACKAGE = "atenpdu"
