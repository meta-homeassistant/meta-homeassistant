SUMMARY = "Asynchronous library to retrieve data from air-Q devices."
HOMEPAGE = "https://github.com/CorantGmbH/aioairq"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa"

SRC_URI[sha256sum] = "ae7f1836114a8707bf6769bb9b6557e75092d233515f28efeb32b78eb63c70a3"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aioairq"
RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-pycryptodome \
"
