SUMMARY = "Asynchronous library to retrieve data from air-Q devices."
HOMEPAGE = "https://github.com/CorantGmbH/aioairq"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# 0.4.8 was published to PyPI as a wheel only, so build from the release tag
SRC_URI = "git://github.com/CorantGmbH/aioairq.git;protocol=https;tag=v${PV};nobranch=1"
SRCREV = "1ecb778ca5b57b0f701fd989e688edf9d36269a5"

inherit python_setuptools_build_meta ptest-python-pytest

SRC_URI:append = " \
    file://run-ptest \
"

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-pycryptodome \
"
