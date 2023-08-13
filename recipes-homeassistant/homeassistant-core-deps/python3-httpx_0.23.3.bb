SUMMARY = "HTTPX - A next-generation HTTP client for Python."
HOMEPAGE = "https://github.com/encode/httpx"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=c624803bdf6fc1c4ce39f5ae11d7bd05"

DEPENDS += "\
    python3-hatch-fancy-pypi-readme-native \
"

SRC_URI[md5sum] = "921ced753cbfeff7d0a8ba80ca455985"
SRC_URI[sha256sum] = "9818458eb565bb54898ccb9b8b251a28785dd4a55afbc23d0eb410754fe7d0f9"

inherit pypi python_hatchling

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-certifi \
    ${PYTHON_PN}-httpcore (>=0.15.0) \
    ${PYTHON_PN}-idna \
    ${PYTHON_PN}-sniffio \
"
