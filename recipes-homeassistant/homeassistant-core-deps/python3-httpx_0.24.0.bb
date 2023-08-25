SUMMARY = "HTTPX - A next-generation HTTP client for Python."
HOMEPAGE = "https://github.com/encode/httpx"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=c624803bdf6fc1c4ce39f5ae11d7bd05"

DEPENDS += "\
    python3-hatch-fancy-pypi-readme-native \
"

SRC_URI[sha256sum] = "507d676fc3e26110d41df7d35ebd8b3b8585052450f4097401c9be59d928c63e"

inherit pypi python_hatchling

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-certifi \
    ${PYTHON_PN}-httpcore (>=0.15.0) \
    ${PYTHON_PN}-idna \
    ${PYTHON_PN}-sniffio \
"
