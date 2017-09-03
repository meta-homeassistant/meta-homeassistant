SUMMARY = "read and write audio tags for many formats"
HOMEPAGE = "https://github.com/quodlibet/mutagen"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS += "${PYTHON_PN}-cython-native"

inherit pypi

SRC_URI[md5sum] = "c54443dfb8d4ac088eb2a0c4fd569772"
SRC_URI[sha256sum] = "23990f70ae678c7b8df3fd59e2adbefa5fe392c36da8c71d2254b21c6cd78766"
