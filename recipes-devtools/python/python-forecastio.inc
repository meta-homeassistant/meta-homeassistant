SUMMARY = "A thin Python Wrapper for the Dark Sky (formerly Forecast.io) weather API"
HOMEPAGE = "http://zeevgilovitz.com/python-forecast.io/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=18b09a20dd186af4fd60f1a08311628c"

inherit pypi

SRC_URI = "https://pypi.python.org/packages/c4/ee/8db21a142548e4b67950068bd78034b67b04900efa79c44c3c2241a3450c/python-forecastio-1.3.5.tar.gz"
SRC_URI[md5sum] = "551e369d65244617c8d1ca9b84e2951e"
SRC_URI[sha256sum] = "15cfcaea91b6eda0a67041e874c9a0c346e593f7dc5be8a513a5f581c63a1ed7"

S = "${WORKDIR}/python-forecastio-1.3.5"
