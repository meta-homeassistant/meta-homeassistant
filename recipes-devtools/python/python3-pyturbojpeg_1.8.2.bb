# FIXME: the LIC_FILES_CHKSUM values have been updated by 'devtool upgrade'.
# The following is the difference between the old and the new license text.
# Please update the LICENSE value if needed, and summarize the changes in
# the commit message via 'License-Update:' tag.
# (example: 'License-Update: copyright years updated.')
#
# The changes:
#
# --- LICENSE
# +++ LICENSE
# @@ -1,6 +1,6 @@
#  MIT License
#  
# -Copyright (c) 2018-2024 Lilo Huang <kuso.cc@gmail.com>
# +Copyright (c) 2018-2025 Lilo Huang <kuso.cc@gmail.com>
#  
#  Permission is hereby granted, free of charge, to any person obtaining a copy
#  of this software and associated documentation files (the "Software"), to deal
# 
#

SUMMARY = "A Python wrapper of libjpeg-turbo for decoding and encoding JPEG image."
HOMEPAGE = "https://github.com/lilohuang/PyTurboJPEG"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae90766639a4f3b8dbbcd774f8fcf050"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b7d9625bbb2121b923228fc70d0c2b010b386687501f5b50acec4501222e152b"

inherit pypi setuptools3

PYPI_PACKAGE = "PyTurboJPEG"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} += "\
    libturbojpeg \
    python3-numpy \
"
