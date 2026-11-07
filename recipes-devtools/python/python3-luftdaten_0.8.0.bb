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
# -Copyright (c) 2017-2022 Fabian Affolter <fabian@affolter-engineering.ch>
# +Copyright (c) 2017-2026 Fabian Affolter <fabian@affolter-engineering.ch>
#
#  Permission is hereby granted, free of charge, to any person obtaining a copy
#  of this software and associated documentation files (the "Software"), to deal
#
#

SUMMARY = "Python API for interacting with luftdaten.info"
HOMEPAGE = "https://github.com/home-assistant-ecosystem/python-luftdaten"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b8bb8643d40e7ee8063674ef25c3b812"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3c476781f60c965bf7b2ea9fa7db3ece368cfbd25f710c049eaf5f735a9a4bdf"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "python3-httpx (>=0.23)"
