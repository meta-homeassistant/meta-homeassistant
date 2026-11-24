SUMMARY = "Async implementation of pyacaia"
HOMEPAGE = "https://github.com/zweckj/aioacaia"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8e4d173e928cda2733a7eab4d555b557"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "61093b41ac3d42bbc8d87f744a886df98905d5d1fe8ab95c052cddc24a073d0b"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "python3-bleak (>=0.20.2)"

RDEPENDS:${PN} += "\
    python3-bleak-retry-connector (>=4.0.0) \
"
