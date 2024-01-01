SUMMARY = "HTTPX - A next-generation HTTP client for Python."
HOMEPAGE = "https://github.com/encode/httpx"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=c624803bdf6fc1c4ce39f5ae11d7bd05"

DEPENDS += "\
    python3-hatch-fancy-pypi-readme-native \
"

SRC_URI[sha256sum] = "47ecda285389cb32bb2691cc6e069e3ab0205956f681c5b2ad2325719751d875"

inherit pypi python_hatchling

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-certifi \
    ${PYTHON_PN}-httpcore (>=0.18.0) \
    ${PYTHON_PN}-idna \
    ${PYTHON_PN}-sniffio \
"
