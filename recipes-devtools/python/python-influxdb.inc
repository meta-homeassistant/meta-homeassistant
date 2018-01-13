SUMMARY = "InfluxDB-Python is a client for interacting with InfluxDB. Maintained by @aviau (https://github.com/aviau)."
HOMEPAGE = "https://github.com/influxdb/influxdb-python"
LICENSE = "MIT"
SRCNAME = "influxdb"

LIC_FILES_CHKSUM = "file://LICENSE;md5=046523829184aac3703a4c60c0ae2104"

inherit pypi

SRC_URI[md5sum] = "a59916ef8882b239eb04033775908bd8"
SRC_URI[sha256sum] = "e3790474fa6d3e39043471a2a79b3309e9a47c63c0803a8810241bc8ce056b18"

RDEPENDS_${PN} = "python3-dateutil"
