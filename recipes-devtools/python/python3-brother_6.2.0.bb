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
# @@ -186,7 +186,7 @@
#        same "printed page" as the copyright notice for easier
#        identification within third-party archives.
#
# -   Copyright 2025 Maciej Bieniek
# +   Copyright 2026 Maciej Bieniek
#
#     Licensed under the Apache License, Version 2.0 (the "License");
#     you may not use this file except in compliance with the License.
#
#

SUMMARY = "Python wrapper for getting data from Brother laser and inkjet printers via SNMP."
HOMEPAGE = "https://github.com/bieniu/brother"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e506a4eaa03b7d260c571595271a50f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "913fe5aff678a8c33c90d6d53ca11d99640f4f5d948b50a3ae882eb113457633"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-dacite (>=1.7.0) \
    python3-pyasn1 \
    python3-pysnmp (>=7.1.6) \
"
