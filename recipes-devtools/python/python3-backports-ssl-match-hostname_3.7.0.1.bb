SUMMARY = "The ssl.match_hostname() function from Python 3.5"
HOMEPAGE = "http://bitbucket.org/brandon/backports.ssl_match_hostname"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=27a27d83b5b4a5fdb34a152fc19c6166"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "bb82e60f9fbf4c080eabd957c39f0641f0fc247d9a16e31e26d594d8f42b9fd2"

inherit pypi setuptools3

PYPI_PACKAGE = "backports.ssl_match_hostname"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
