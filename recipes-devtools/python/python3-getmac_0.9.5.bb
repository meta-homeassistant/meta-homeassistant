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
# @@ -1,21 +1,21 @@
# -MIT License
# -
# -Copyright (c) 2019 Christopher Goes
# -
# -Permission is hereby granted, free of charge, to any person obtaining a copy
# -of this software and associated documentation files (the "Software"), to deal
# -in the Software without restriction, including without limitation the rights
# -to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# -copies of the Software, and to permit persons to whom the Software is
# -furnished to do so, subject to the following conditions:
# -
# -The above copyright notice and this permission notice shall be included in all
# -copies or substantial portions of the Software.
# -
# -THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# -IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# -FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# -AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# -LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# -OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
# -SOFTWARE.
# +MIT License
# +
# +Copyright (c) 2019 Christopher Goes
# +
# +Permission is hereby granted, free of charge, to any person obtaining a copy
# +of this software and associated documentation files (the "Software"), to deal
# +in the Software without restriction, including without limitation the rights
# +to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# +copies of the Software, and to permit persons to whom the Software is
# +furnished to do so, subject to the following conditions:
# +
# +The above copyright notice and this permission notice shall be included in all
# +copies or substantial portions of the Software.
# +
# +THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# +IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# +FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# +AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# +LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# +OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
# +SOFTWARE.
# 
#

SUMMARY = "Platform-independent pure-Python module to get a MAC address"
HOMEPAGE = "https://github.com/GhostofGoes/getmac"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=31a1bcc022ed7c0b08b8f4894f708147"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "456435cdbf1f5f45c433a250b8b795146e893b6fc659060f15451e812a2ab17d"

inherit pypi setuptools3
