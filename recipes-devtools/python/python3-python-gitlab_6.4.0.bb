SUMMARY = "The python wrapper for the GitLab REST and GraphQL APIs."
HOMEPAGE = "https://github.com/python-gitlab/python-gitlab"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "55ed94fb47932124b7f9df8e72b29352d3d0ee01ecf44f081dd070f4bad8700d"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-requests (>=2.32.5) \
    python3-requests-toolbelt (>=1.0.0) \
"
PYPI_PACKAGE = "python_gitlab"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
