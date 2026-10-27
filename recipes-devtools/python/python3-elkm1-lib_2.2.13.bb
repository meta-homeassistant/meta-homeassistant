SUMMARY = "Library for interacting with ElkM1 alarm/automation panel."
HOMEPAGE = "https://github.com/gwww/elkm1"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE;md5=34a0716df7fee7be0603abfdd3bf023c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5e7dbb7bf0951a39b013b3b87a4ae4edc879af47b7f75397fd2d32970566ab92"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "python3-pyserial-asyncio-fast (>=0.11)"

RDEPENDS:${PN}-ptest += "\
    python3-attrs \
    python3-pytest-asyncio \
"

PTEST_PYTEST_DIR = "test"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
