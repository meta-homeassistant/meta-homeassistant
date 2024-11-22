SUMMARY = "Asynchronous library to retrieve data from air-Q devices."
HOMEPAGE = "https://github.com/CorantGmbH/aioairq"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa"

SRC_URI[sha256sum] = "0b42529c77086418f6c4dcb6abb8039ef0de2819e8ad3f577299424ed92ffa93"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aioairq"
RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-pycryptodome \
"
