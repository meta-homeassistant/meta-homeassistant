SUMMARY = "A native Python KNX/IPNet implementation"
HOMEPAGE = "http://github.com/usul27/pknx"
LICENSE = "MIT"
#TODO: Use correct file once is fixed: https://github.com/open-homeautomation/pknx/issues/17
#LIC_FILES_CHKSUM = "file://COPYING;md5=d7dba1721bc8ce05d421f7279cb87971"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=d86758afb08a60bc589dc67bfea670b2"

inherit pypi setuptools3

SRC_URI[md5sum] = "86945a8626163ddad193af0c63a0d46e"
SRC_URI[sha256sum] = "436d02275a7e12356384b470c45651d560085012d83220e6163342f3a7e469a7"
