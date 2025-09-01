SUMMARY = "This is the core of the python lib. It contains shared classes, definitions and utils. "
HOMEPAGE = "https://github.com/crownstone/crownstone-lib-python-core"
LICENSE = "LGPL-3.0-only & MIT & Apache-2.0"
LIC_FILES_CHKSUM = "\
    file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
    file://${COMMON_LICENSE_DIR}/LGPL-3.0-only;md5=bfccfe952269fff2b407dd11f2f3083b \
    file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10 \
"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "df4893f2f241498be41131bf676f2d5bf7ba9fb02acc3add812121c458bcb306"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-pyaes (>=1.6)"

PYPI_PACKAGE = "crownstone-core"
