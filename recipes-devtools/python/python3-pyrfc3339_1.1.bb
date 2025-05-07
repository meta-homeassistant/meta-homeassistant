DESCRIPTION = "Python library for generating and parsing RFC 3339-compliant timestamps."
HOMEPAGE = "https://github.com/kurtraschke/pyRFC3339"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=91b3003300a14a301fc1efc878bcee51"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi setuptools3

PYPI_PACKAGE = "pyRFC3339"

SRC_URI[md5sum] = "c829980738b8271b0179ffd0c41187b0"
SRC_URI[sha256sum] = "81b8cbe1519cdb79bed04910dd6fa4e181faf8c88dff1e1b987b5f7ab23a5b1a"

RDEPENDS:${PN} = "\
    python3-pytz \
"
