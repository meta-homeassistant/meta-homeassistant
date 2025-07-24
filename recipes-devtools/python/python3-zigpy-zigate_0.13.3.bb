SUMMARY = "A library which communicates with ZiGate radios for zigpy"
HOMEPAGE = "https://github.com/zigpy/zigpy-zigate"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI += "file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "10b653ecf6741e60194f1fc9a9c2cbc614aa87f597578bc01141759913de122d"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "zigpy_zigate"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-gpiozero \
    python3-pyusb (>=1.1.0) \
    python3-voluptuous \
    python3-zigpy (>=0.70.0) \
"
