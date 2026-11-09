SUMMARY = "Work with the Webex APIs in native Python!"
HOMEPAGE = "https://github.com/WebexCommunity/WebexPythonSDK"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54292234461e96a39f4005148a3fb016"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f28f5bfbc460208a7704f3adef3d79a4d0d6501ed60638d7ce7e83972346c4a2"

DEPENDS += "python3-poetry-dynamic-versioning-native"

inherit pypi python_poetry_core


RDEPENDS:${PN} = "\
    python3-requests (>=2.32.3) \
    python3-requests-toolbelt (>=1.0.0) \
    python3-pyjwt (>=2.8.0) \
"
