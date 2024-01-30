SUMMARY = "A pure Python netlink and Linux network configuration library"
HOMEPAGE = "https://github.com/svinota/pyroute2"
LICENSE = "GPL-2.0-only & Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.GPL-2.0-or-later;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://LICENSE.Apache-2.0;md5=34281e312165f843a2b7d1f114fe65ce"

SRC_URI[sha256sum] = "1eeb2fa3e2543357df0a937a700c5b6761b2aa5284400aed46206470fe5c0be5"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-ctypes \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-multiprocessing \
    ${PYTHON_PN}-pickle \
    ${PYTHON_PN}-pkgutil \
    ${PYTHON_PN}-pprint \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-unixadmin \
"
