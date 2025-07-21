SUMMARY = "Kusto Data Client"
HOMEPAGE = "https://github.com/Azure/azure-kusto-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "48db0ce481ccedc4007a4491e851d12ac38381b5690be0ca051a153e224baf3c"

inherit pypi setuptools3

#PACKAGECONFIG ?= "aio pandas"
PACKAGECONFIG[aio] = ",,,python3-aiohttp python3-asgiref"
PACKAGECONFIG[pandas] = ",,,python3-pandas"

RDEPENDS:${PN} += "\
    python3-azure-core (>=1.33.0) \
    python3-azure-identity (>=1.21.0) \
    python3-ijson (>=3.1) \
    python3-msal (>=1.9.0) \
    python3-dateutil (>=2.8.0) \
    python3-requests (>=2.32.3) \
"

PYPI_PACKAGE = "azure-kusto-data"
