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
# @@ -1,5 +1,5 @@
#  
# -Copyright (C) 2001-2020 Michael Teo <miketeo (a) miketeo.net>
# +Copyright (C) 2001-2025 Michael Teo <miketeo (a) miketeo.net>
#  
#  This software is provided 'as-is', without any express or implied warranty.
#  In no event will the author be held liable for any damages arising from the
# 
#

SUMMARY = "pysmb is an experimental SMB/CIFS library written in Python to support file sharing between Windows and Linux machines"
HOMEPAGE = "https://miketeo.net/projects/pysmb"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://LICENSE;md5=148dfe87589388f86bab72dd27ab8fa1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3a33214f737e877a8ead579e63c9944941deff5e12100e1ca65311b230b1786a"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-pyasn1 \
    python3-tqdm \
"

PYPI_PACKAGE = "pysmb"
PYPI_PACKAGE_EXT = "zip"
