SUMMARY = "An API wrapper for Epic Games Store written in Python"
HOMEPAGE = "https://github.com/SD4RK/epicstore_api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73257f5dc799de86a1e3890a3f384135"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4f92571861dd01b366d0a342a0e1e143ad0e1e66057ac6e76ab26c446f772a30"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
    python3-requests \
"
