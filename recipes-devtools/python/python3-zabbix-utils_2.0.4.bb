SUMMARY = "A library with modules for working with Zabbix (Zabbix API, Zabbix sender, Zabbix get)"
HOMEPAGE = "https://github.com/zabbix/python-zabbix-utils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=710a016c654729e2084ef6ac8b242c7f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e46b15c5b51ade4692aa009939372bce68871cf64d6572e96e8cb193cb0590ea"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp"
