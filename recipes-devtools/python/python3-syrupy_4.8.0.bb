SUMMARY = "Pytest Snapshot Test Utility"
HOMEPAGE = "https://github.com/tophat/syrupy"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a74db8ae475d2bd439d60ff9df4e3e3"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "648f0e9303aaa8387c8365d7314784c09a6bab0a407455c6a01d6a4f5c6a8ede"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "python3-pytest"
