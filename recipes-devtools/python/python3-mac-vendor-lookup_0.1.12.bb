SUMMARY = "This Python library provides an easy way to get vendor information from a MAC address"
HOMEPAGE = "https://github.com/bauerj/mac_vendor_lookup"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENCE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# Pypi only offers the wheel version and no tar-gz for this package. Also Github does not have a tarball.
# Revert to manual building
SRC_URI = "git://github.com/bauerj/mac_vendor_lookup.git;protocol=https;branch=master \
           file://0001-Added-mac-vendors.txt.patch \
"
SRCREV = "90dbea48f8a9d567b5f9039ebd151ddfe7d12a19"

S = "${WORKDIR}/git"

inherit python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-aiofiles \
    python3-aiohttp \
"

FILES:${PN} += "\
    /usr/cache \
"
