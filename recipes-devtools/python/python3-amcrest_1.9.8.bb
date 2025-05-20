SUMMARY = "Python wrapper implementation for Amcrest cameras."
HOMEPAGE = "http://github.com/tchellomello/python-amcrest"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "bfc82cc2befa5cf94fcbb1ebe4d5d0ecb4668cfd4a53e6242cf27ff681ab66d2"

inherit pypi setuptools3

# WARNING: the following rdepends are from setuptools install_requires. These
# upstream names may not correspond exactly to bitbake package names.
RDEPENDS:${PN} += "\
    python3-argcomplete \
    python3-httpx \
    python3-requests \
    python3-typing-extensions \
    python3-urllib3 \
"

PYPI_PACKAGE = "amcrest"
