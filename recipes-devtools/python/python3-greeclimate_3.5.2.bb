SUMMARY = "Discover, connect and control Gree based minisplit systems"
HOMEPAGE = "https://github.com/cmroche/greeclimate"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e49f4652534af377a713df3d9dec60cb"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/cmroche/greeclimate;protocol=https;tag=v${PV};branch=master"
SRCREV = "43595daab7bb01bd8153727a25b37bab218f5828"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-netifaces python3-pycryptodome"

RDEPENDS:${PN}-ptest:append = " \
    python3-ifaddr \
    python3-pytest-asyncio \
"

do_install_ptest:append() {
    # asyncio_mode = auto lives in the [tool:pytest] section of setup.cfg
    install -m 0644 ${S}/setup.cfg ${D}${PTEST_PATH}/
    # test_emulator loads the example emulator configuration
    install -d ${D}${PTEST_PATH}/examples
    install -m 0644 ${S}/examples/emulator-devices.json ${D}${PTEST_PATH}/examples/
    # test_release checks upstream's .github/scripts/validate-release.py with
    # git; it tests their release tooling, not the library
    rm -f ${D}${PTEST_PATH}/tests/test_release.py
}
