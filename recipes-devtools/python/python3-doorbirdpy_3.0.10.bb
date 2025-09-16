SUMMARY = "Python wrapper for the DoorBird LAN API"
HOMEPAGE = "https://gitlab.com/klikini/doorbirdpy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b28eb8fc319eb8f3e78193983dfb80bd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "33271e3c0c2f9d6fcd818b9ca059bcd544c1d206896b6c5421d0766476953fb9"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-tenacity (>=9) \
"
