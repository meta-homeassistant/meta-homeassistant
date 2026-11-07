SUMMARY = "Keep all y'all's __all__'s in sync"
DESCRIPTION = "Provides the @public and @private decorators, which document \
    the public visibility of the names in a module and keep its __all__ in \
    sync."
HOMEPAGE = "https://gitlab.com/flufl/public"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=352079383495020c27baf96dae1cf7db"

SRC_URI[sha256sum] = "61ea62d8445d2aaa83b6dffaa3d90f99fcec10e16683ee9b13792cdcdafa0966"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN}-ptest += "python3-xml"

# conftest.py also collects the docs/*.rst doctests through sybil, which is not
# packaged; the docs are not installed either, so that part is dropped.
do_install_ptest:append() {
    sed -e '/^from sybil/d' -e '/^pytest_collect_file = Sybil(/,$d' \
        ${S}/conftest.py > ${D}${PTEST_PATH}/conftest.py
}
