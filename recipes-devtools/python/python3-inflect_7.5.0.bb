SUMMARY = "Correctly generate plurals, singular nouns, ordinals, indefinite articles"
HOMEPAGE = "https://github.com/jaraco/inflect"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=141643e11c48898150daa83802dbc65f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-scm-native \
"

SRC_URI[sha256sum] = "faf19801c3742ed5a05a8ce388e0d8fe1a07f8d095c82201eb904f5d27ad571f"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "inflect"
RDEPENDS:${PN} = "\
    python3-typeguard (>=4.0.1) \
    python3-more-itertools (>=8.5.0) \
"
