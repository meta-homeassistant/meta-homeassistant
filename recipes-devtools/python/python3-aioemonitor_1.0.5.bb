SUMMARY = "Asyncio Python lib for SiteSage Emonitor"
HOMEPAGE = "https://github.com/bdraco/aioemonitor"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5c1e4dcca80a6a841c085ded9c25b768"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-remove-setup-requirement.patch"
SRC_URI[sha256sum] = "36f82bd7bfd3a52c1fcfe70c2c99db4ef28ec0a780e23f2ad8286a1f18f31b68"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.7.0) \
    python3-xmltodict (>=0.12.0) \
"

PYPI_PACKAGE = "aioemonitor"
