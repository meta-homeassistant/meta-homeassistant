SUMMARY = "Retrieve a list of devices from a bt smarthub or bt smarthub 2 on a local network"
HOMEPAGE = "https://github.com/jxwolstenholme/btsmarthub_devicelist"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b9565535a779da398478ec10e68f5e28"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ad3c155c06313d760d55560297b7288771989884efbd9f33bc2713fcab6e200c"

inherit pypi setuptools3

PYPI_PACKAGE = "btsmarthub_devicelist"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
