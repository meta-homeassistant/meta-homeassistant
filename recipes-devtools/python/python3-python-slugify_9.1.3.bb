SUMMARY = "A Python Slugify application that handles Unicode"
HOMEPAGE = "https://github.com/un33k/python-slugify"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7946d011d653bfcfbb24480377867128"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "90e997f2e0987239ce95e12f700086eb18e1d1d3ee22624fbbdbd095afca42b6"

RDEPENDS:${PN} = "\
    python3-text-unidecode (>=1.3) \
"
