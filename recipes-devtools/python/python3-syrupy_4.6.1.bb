SUMMARY = "Pytest Snapshot Test Utility"
HOMEPAGE = "https://github.com/tophat/syrupy"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5792ba68383cea1c5a8149061cc66801"

SRC_URI[sha256sum] = "37a835c9ce7857eeef86d62145885e10b3cb9615bc6abeb4ce404b3f18e1bb36"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "python3-pytest"
