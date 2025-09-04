SUMMARY = "A full-featured Python package for parsing and creating iCalendar and vCard files"
HOMEPAGE = "http://py-vobject.github.io/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE-2.0.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI += "file://0001-Add-missing-version-info.patch"
SRC_URI[sha256sum] = "ac44e5d7e2079d84c1d52c50a615b9bec4b1ba958608c4c7fe40cbf33247b38e"

inherit pypi setuptools3 dos2unix

RDEPENDS:${PN} += "\
    python3-pytz \
    python3-six \
    python3-dateutil (>=2.7.0) \
"

PYPI_PACKAGE = "vobject"
