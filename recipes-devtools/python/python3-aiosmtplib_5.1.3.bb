SUMMARY = "asyncio SMTP client"
DESCRIPTION = "aiosmtplib is an asynchronous SMTP client for use with asyncio."
HOMEPAGE = "https://pypi.org/project/aiosmtplib"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2b9776f33ed0a7fe8823d389e2d7c539"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ac2b418d3260ba62d9cfd0fe7359726e9dc009a4e8e8d9909fdfae332f522a7c"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN}-ptest += "\
    python3-aiosmtpd \
    python3-hypothesis \
    python3-pytest-asyncio \
    python3-trustme \
    python3-uvloop \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
