SUMMARY = "Python module for handling audio metadata"
HOMEPAGE = "https://github.com/quodlibet/mutagen"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "719fadef0a978c31b4cf3c956261b3c58b6948b32023078a2117b1de09f0fc99"

RDEPENDS:${PN} += "\
    python3-core (>=3.7) \
"
