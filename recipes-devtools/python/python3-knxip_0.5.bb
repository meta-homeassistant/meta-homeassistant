SUMMARY = "A native Python KNX/IPNet implementation"
HOMEPAGE = "http://github.com/usul27/pknx"
LICENSE = "MIT"
#TODO: Use correct file once is fixed: https://github.com/open-homeautomation/pknx/issues/17
#LIC_FILES_CHKSUM = "file://COPYING;md5=d7dba1721bc8ce05d421f7279cb87971"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=3f78c6150b7d619a476c799812e31d5a"

inherit pypi setuptools3

SRC_URI[md5sum] = "28351b1e33704f1f118e220a38fe8563"
SRC_URI[sha256sum] = "2190b0bc159dfa7e681e09a25dd880f3d9e36ad90dee2d1a798e35a5b81db516"
