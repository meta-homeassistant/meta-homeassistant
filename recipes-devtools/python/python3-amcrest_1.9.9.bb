SUMMARY = "Python wrapper implementation for Amcrest cameras."
HOMEPAGE = "http://github.com/tchellomello/python-amcrest"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "bc97dfb3f946c8b6d368fcf6fc8541e09a2a3f4a63d0171edf3a1b4a5715883e"

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
