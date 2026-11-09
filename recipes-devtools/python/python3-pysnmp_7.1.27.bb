# FIXME: the LIC_FILES_CHKSUM values have been updated by 'devtool upgrade'.
# The following is the difference between the old and the new license text.
# Please update the LICENSE value if needed, and summarize the changes in
# the commit message via 'License-Update:' tag.
# (example: 'License-Update: copyright years updated.')
#
# The changes:
#
# --- LICENSE.rst
# +++ LICENSE.rst
# @@ -1,5 +1,5 @@
#  Copyright (c) 2005-2020, Ilya Etingof <etingof@gmail.com>
# -Copyright (c) 2022-2025, LeXtudio Inc. <support@lextudio.com>
# +Copyright (c) 2022-2026, LeXtudio Inc. <support@lextudio.com>
#  All rights reserved.
#
#  Redistribution and use in source and binary forms, with or without
#
#

SUMMARY = "A Python library for SNMP"
HOMEPAGE = "https://pysnmp.com/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=57ee828406c11080ad9bd7eabdc5ae1b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "01ce32d1bb0a14e8e3410a43fb7a8a7b050ec06186dc9ec240fcefa4af8b963c"

inherit pypi python_flit_core

RDEPENDS:${PN} = "\
	python3-pyasn1 (>=0.4.8) \
"
