SUMMARY = "python-nmap is a python library which helps in using nmap port scanner. It allows to easilly manipulate nmap scan results and will be a perfect tool for systems administrators who want to automatize scanning task and reports. It also supports nmap script outputs."
HOMEPAGE = "http://xael.org/pages/python-nmap-en.html"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://gpl-3.0.txt;md5=d32239bcb673463ab874e80d47fae504"

PYPI_PACKAGE = "python-nmap"

inherit pypi

SRC_URI[md5sum] = "2795bfcbc05cbbbccfcf4df59facaab1"
SRC_URI[sha256sum] = "80ba0eb10a52283a54a633f40b5baa9c2ff08675d6621dd089ead942852f5bd3"

RDEPENDS_${PN} = "${PYTHON_PN}-xml nmap"

BBCLASSEXTEND = "native"
