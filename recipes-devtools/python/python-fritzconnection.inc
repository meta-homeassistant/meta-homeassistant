SUMMARY = "Python-Tool to communicate with the AVM FritzBox. Uses the TR-064 protocol"
HOMEPAGE = "https://bitbucket.org/kbr/fritzconnection"
LICENSE = "MIT"
# TODO: https://bitbucket.org/kbr/fritzconnection/pull-requests/12/add-readme-and-license-to-pypi-tarball/diff
LIC_FILES_CHKSUM = "file://setup.cfg;md5=d86758afb08a60bc589dc67bfea670b2"

inherit pypi

SRC_URI[md5sum] = "d8eee6d7519b8c02f4301b6fb5cad76a"
SRC_URI[sha256sum] = "ba0dc50cb5fca5a913a65c875b9814d262b9c27a320f37dfeab4189c6fd7e391"

RDEPENDS_${PN} = "${PYTHON_PN}-lxml ${PYTHON_PN}-requests"
