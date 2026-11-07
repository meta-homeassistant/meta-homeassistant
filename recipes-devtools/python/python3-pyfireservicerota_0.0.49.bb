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
# -Copyright (c) 2020-2025 Ron Klinkien
# +Copyright (c) 2020-2026 Ron Klinkien
#
#  Permission is hereby granted, free of charge, to any person obtaining a copy
#  of this software and associated documentation files (the "Software"), to deal
#
#

SUMMARY = "Python 3 API wrapper for FireServiceRota/BrandweerRooster"
HOMEPAGE = "https://github.com/cyberjunky/python-fireservicerota"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a6b577fee70e992fb738a8c899402b2b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "652da7c2ddddac7e98583c3bf7e09aa0860d6d8356485856cfdd81df1866930d"

DEPENDS = "python3-pdm-backend-native"

inherit pypi python_pdm

RDEPENDS:${PN} = "\
	python3-oauthlib \
	python3-pytz \
	python3-requests \
	python3-websocket-client \
"
