SUMMARY = "JSON API to document parser"
HOMEPAGE = "https://github.com/noplay/json-api-doc"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=590a3fe69dec1ae6d5f4e74171c4ff0f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1cbbf34d04b7768bf0de187363333a1c96294588e778f722a98ef60765458a9c"

DEPENDS = "python3-pytest-runner-native"

inherit pypi setuptools3
