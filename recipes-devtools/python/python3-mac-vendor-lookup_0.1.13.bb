SUMMARY = "Find the vendor for a given MAC address"
HOMEPAGE = "https://github.com/bauerj/mac_vendor_lookup"
LICENSE = "Apache-2.0"
# nooelint: oelint.var.licenseremotefile - False positive, the license file is in the wheel package
LIC_FILES_CHKSUM = "file://${WHL_BP}.dist-info/LICENCE;md5=d229da563da18fe5d58cd95a6467d584"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi_wheel

WHL_PKG_URI = "ec/9a/dbe0e8bcbf59debe8a6d5381da9ae3c8cfbfbdf4efdfb21a26fca2adee58"
WHL_BP = "mac_vendor_lookup-${PV}"
WHL_PN = "mac_vendor_lookup"
WHL_BPN = ""

WHL_SHA256SUM = "6c2b5ac4b27dab71ed43f7ac6402c6fde1463bcd730b8d58417f0004b3aafd40"
