SUMMARY = "Work with the Webex APIs in native Python!"
HOMEPAGE = "https://github.com/WebexCommunity/WebexPythonSDK"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54292234461e96a39f4005148a3fb016"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3796c163aa99b845c7c63fd1d4760bbf00f3449cb487a128356c052f526697ae"

DEPENDS += "python3-poetry-dynamic-versioning-native"

inherit pypi python_poetry_core

PYPI_PACKAGE = "webexpythonsdk"

RDEPENDS:${PN} = "\
    python3-requests (>=2.32.3) \
    python3-requests-toolbelt (>=1.0.0) \
    python3-pyjwt (>=2.8.0) \
"
