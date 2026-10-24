SUMMARY = "Test asyncio code more easily."
DESCRIPTION = "A library that makes testing asyncio code easier."
HOMEPAGE = "https://github.com/kwarunek/aiounittest"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aac912b9e2b3137a1a5e4362a26af7e4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-adjust-for-python3.14-compat.patch"
SRC_URI[sha256sum] = "3c20ab00909419749061a4cb1a2755f034d10c1f6455adb1f03d7c16dedce711"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-asyncio \
    python3-unittest \
    python3-wrapt \
"
