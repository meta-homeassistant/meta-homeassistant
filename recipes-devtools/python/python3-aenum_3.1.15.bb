SUMMARY = "Advanced Enumerations (compatible with Python's stdlib Enum), NamedTuples, and NamedConstants"
HOMEPAGE = "https://github.com/ethanfurman/aenum"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://aenum/LICENSE;md5=c6a85477543f8b8591b9c1f82abebbe9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8cbd76cd18c4f870ff39b24284d3ea028fbe8731a58df3aa581e434c575b9559"

inherit pypi setuptools3

PYPI_PACKAGE = "aenum"
RPROVIDES:${PN} = "aenum"
