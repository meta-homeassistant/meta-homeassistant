SUMMARY = "A library with modules for working with Zabbix (Zabbix API, Zabbix sender, Zabbix get)"
HOMEPAGE = "https://github.com/zabbix/python-zabbix-utils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=710a016c654729e2084ef6ac8b242c7f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "2fdb3873bff1151b744a9cd5664522d398782cdd3a56cc6b998179f5c989e78a"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp"

PYPI_PACKAGE = "zabbix_utils"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
