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
#  The MIT License (MIT)
#  
# -Copyright © 2014-2021 Pierre Nicolas Durette
# +Copyright © 2014-2024 Pierre Nicolas Durette
#  
#  Permission is hereby granted, free of charge, to any person obtaining a copy
#  of this software and associated documentation files (the "Software"), to deal
# 
#

SUMMARY = "Python library and CLI tool to interface with Google Translate's text-to-speech API"
HOMEPAGE = "https://github.com/pndurette/gTTS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3f9e2857e297482569ee81ba5205ce4b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "gTTS"
PYPI_SRC_URI = "git://github.com/pndurette/gTTS;protocol=https;branch=main"

SRCREV = "5007fa454d296ab77249ab706af4bc299e500401"

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-click \
    python3-requests \
    python3-six \
"
