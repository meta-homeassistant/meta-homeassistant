SUMMARY = "Hosted coverage reports for GitHub, Bitbucket and Gitlab"
HOMEPAGE = "https://github.com/codecov/codecov-python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=650b6b7ede4fbd14ab012aceb71d69d7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi setuptools3

SRC_URI[sha256sum] = "2362b685633caeaf45b9951a9b76ce359cd3581dd515b430c6c3f5dfb4d92a8c"

RDEPENDS:${PN} = "\
    python3-requests (>=2.7.9) \
    python3-coverage \
"
