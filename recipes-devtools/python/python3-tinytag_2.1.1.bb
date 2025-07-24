SUMMARY = "Read audio file metadata"
HOMEPAGE = "https://github.com/tinytag/tinytag"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b37f9f84c13eedf9ff42f49135da6ed"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b417d480cf3b0c2d60a3afef705b29ac0080fc72d35b0b579b64184c54ee394c"

inherit pypi python_flit_core

PYPI_PACKAGE = "tinytag"
