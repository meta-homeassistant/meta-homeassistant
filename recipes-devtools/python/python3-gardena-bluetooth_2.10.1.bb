SUMMARY = "This module support controlling gardena bluetooth enabled watering computers."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=11afde19ff9d72b16eafac777ea8ca32"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e3b5ca6e341a57d20cfdbbec615753df1b6319df711e46ee411f014ad640be83"

inherit pypi python_hatchling

RDEPENDS:${PN} = "\
    python3-bleak (>=0.20.2) \
    python3-bleak-retry-connector (>=3.0.2) \
    python3-tzlocal (>=5.0.1) \
"

DEPENDS += "python3-uv-dynamic-versioning-native"
