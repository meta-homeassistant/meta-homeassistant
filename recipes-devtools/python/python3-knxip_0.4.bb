SUMMARY = "A native Python KNX/IPNet implementation"
HOMEPAGE = "http://github.com/usul27/pknx"
LICENSE = "MIT"
#TODO: Use correct file once is fixed: https://github.com/open-homeautomation/pknx/issues/17
#LIC_FILES_CHKSUM = "file://COPYING;md5=d7dba1721bc8ce05d421f7279cb87971"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=3f78c6150b7d619a476c799812e31d5a"

inherit pypi setuptools3

SRC_URI[md5sum] = "4abebfe4837669e9e4b372346a97e5ce"
SRC_URI[sha256sum] = "f96e98b07e46b1ceebd60a3cb5759745f88207241c2e3af7d3de592a0ebcbd01"
