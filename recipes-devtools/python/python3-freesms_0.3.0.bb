SUMMARY = "Send SMSes with Free Mobile"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5dfbb677c46ce5c9f6b5cbf579d3fc8d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3ce0747b09b528c2eb85bbf01ce24feae8d344014c6ecae938932138a4ee613f"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-requests (>=2.32.3) \
"

PYPI_PACKAGE = "freesms"
