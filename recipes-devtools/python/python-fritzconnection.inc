SUMMARY = "Python-Tool to communicate with the AVM FritzBox. Uses the TR-064 protocol"
HOMEPAGE = "https://bitbucket.org/kbr/fritzconnection"
LICENSE = "MIT"
# TODO: https://bitbucket.org/kbr/fritzconnection/pull-requests/12/add-readme-and-license-to-pypi-tarball/diff
LIC_FILES_CHKSUM = "file://setup.cfg;md5=d86758afb08a60bc589dc67bfea670b2"

inherit pypi

SRC_URI[md5sum] = "61e2afcbcab5a9535687fef8a955f21c"
SRC_URI[sha256sum] = "02e6e8a392c69dd3e173cec03800332a3ee377cd6c49066739806b51eba2ed41"

RDEPENDS_${PN} = "${PYTHON_PN}-lxml ${PYTHON_PN}-requests"
