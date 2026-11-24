SUMMARY = "A small sentence splitter for text streams"
HOMEPAGE = "http://github.com/OHF-Voice/sentence-stream"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b06261d35729de97df9002a1cc708f9a888f662b80d5d6d008ee69c51f36041b"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "python3-regex (>=2024.11.6)"
