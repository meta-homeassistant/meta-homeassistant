SUMMARY = "Find the vendor for a given MAC address"
HOMEPAGE = "https://github.com/bauerj/mac_vendor_lookup"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WHL_BP}.dist-info/METADATA;md5=428346cfc1f73cfbbde445c29c123ef1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi_wheel

WHL_PKG_URI = "ec/9a/dbe0e8bcbf59debe8a6d5381da9ae3c8cfbfbdf4efdfb21a26fca2adee58"
WHL_BP = "mac_vendor_lookup-${PV}"
WHL_PN = "mac_vendor_lookup"
WHL_BPN = ""

SRC_URI[x86_64.sha256sum] = "6c2b5ac4b27dab71ed43f7ac6402c6fde1463bcd730b8d58417f0004b3aafd40"
