SUMMARY = "A library with modules for working with Zabbix (Zabbix API, Zabbix sender, Zabbix get)"
HOMEPAGE = "https://github.com/zabbix/python-zabbix-utils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=710a016c654729e2084ef6ac8b242c7f"

SRC_URI[sha256sum] = "3c4a98a24c101d89fd938ebe0ad6c9aaa391ac901f2afb75ae682eea88fb77af"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp"

PYPI_PACKAGE = "zabbix_utils"
