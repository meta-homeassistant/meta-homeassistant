SUMMARY = "A library which communicates with ZiGate radios for zigpy"
HOMEPAGE = "https://github.com/zigpy/zigpy-zigate"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI += "file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "09be77737fdbda9ef439996878ac1c04e8fdedc91f284c9ec05d338bce404802"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "zigpy_zigate"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-gpiozero \
    python3-pyusb (>=1.1.0) \
    python3-voluptuous \
    python3-zigpy (>=0.70.0) \
"
