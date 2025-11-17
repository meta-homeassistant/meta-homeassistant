SUMMARY = "Python module to get stock data from the Alpha Vantage Api"
HOMEPAGE = "https://github.com/RomelTorres/alpha_vantage"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=964649b19685165a2ececf0359177502"

SRC_URI[sha256sum] = "f97fe2b8efad2da97580199d54f8556c8007053870c462d10b9eaa815186c484"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp python3-requests"

PYPI_PACKAGE = "alpha_vantage"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
