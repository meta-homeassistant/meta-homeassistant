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
