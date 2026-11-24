SUMMARY = "devolo Home Control API in Python"
HOMEPAGE = "https://github.com/2Fake/devolo_home_control_api"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5f9d3eef882e2e8f03845065d2e8754abb2187fde10ae7986da7697b99d1ca59"

DEPENDS += "python3-setuptools-scm-native"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-dateutil (>=2.8.0) \
    python3-requests (>=2.4.0) \
    python3-websocket-client (>=0.58.0) \
    python3-zeroconf (>=0.38.0) \
"
