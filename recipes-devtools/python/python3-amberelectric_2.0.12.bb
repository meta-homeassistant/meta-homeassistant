SUMMARY = "Amber Electric Public API"
HOMEPAGE = "https://github.com/madpilot/amberelectric.py"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f9868a9dc1babed846d3fcc1e734f5b5"

SRC_URI[sha256sum] = "2970a8c0e59643b830606d8d7d2f12ced24f73be572016b7d0356f5479fdcc20"

inherit pypi python_poetry_core

PYPI_PACKAGE = "amberelectric"
RDEPENDS:${PN} = "\
    python3-aenum (>=3.1.11) \
    python3-dateutil (>=2.8.2) \
    python3-pydantic (>=1.10.5) \
    python3-urllib3 (>=1.25.3) \
"
