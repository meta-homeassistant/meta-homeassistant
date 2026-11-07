SUMMARY = "asyncio based SMTP server"
DESCRIPTION = "aiosmtpd provides an asyncio based implementation of an SMTP \
    and LMTP server, including a controller to run it in a separate thread."
HOMEPAGE = "https://github.com/aio-libs/aiosmtpd"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bc741cc0ff820d7ffcfd7cc66d8ac370"

SRC_URI += "\
    file://0001-migrate-config_test-from-pkg_resources-to-importlib_.patch \
    file://0002-Python-3.16-compat-use-inspect.iscoroutinefunction.patch \
    file://run-ptest \
"
SRC_URI[sha256sum] = "5a811826e1a5a06c25ebc3e6c4a704613eb9a1bcf6b78428fbe865f4f6c9a4b8"

DEPENDS += "python3-wheel-native"

inherit pypi python_setuptools_build_meta ptest

RDEPENDS:${PN} += "\
    python3-asyncio \
    python3-atpublic \
    python3-attrs \
    python3-email \
    python3-mailbox \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest \
    python3-pytest-asyncio \
    python3-pytest-mock \
    python3-setuptools \
    python3-typing-extensions \
    python3-unittest-automake-output \
"

do_install_ptest() {
    # Upstream's pytest.ini without the coverage options and the testpaths,
    # which point into the source tree. pytest-asyncio warns when the fixture
    # loop scope is unset, and filterwarnings = error turns that into an
    # internal error, so set it to the scope it defaults to. The same goes for
    # the two custom marks of the test suite, which upstream does not register.
    sed -e '/--cov/d' -e '/^testpaths/d' \
        -e 's/^asyncio_mode = auto$/&\nasyncio_default_fixture_loop_scope = function/' \
        -e 's/^xfail_strict = true$/&\nmarkers =\n    controller_data\n    handler_data/' \
        ${S}/pytest.ini > ${D}${PTEST_PATH}/pytest.ini
}
