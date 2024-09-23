SUMMARY = "Python module to work with zabbix."
HOMEPAGE = "https://github.com/blacked/py-zabbix"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=126;endline=126;md5=209bb8edc9ee063850ae9dbdfae99993"

SRC_URI[sha256sum] = "0176569e61b134a9e445d9086cdfe895583ffe938f34deea3a9cffa78011e459"

inherit pypi setuptools3

PYPI_PACKAGE = "py-zabbix"
