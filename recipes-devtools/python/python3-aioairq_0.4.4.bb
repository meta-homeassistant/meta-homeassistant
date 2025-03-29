SUMMARY = "Asynchronous library to retrieve data from air-Q devices."
HOMEPAGE = "https://github.com/CorantGmbH/aioairq"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e76055c7e16250f3ba33bd9998f470aa5aee7a8719b4083ce5e658cf64bc1e36"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aioairq"
RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-pycryptodome \
"
