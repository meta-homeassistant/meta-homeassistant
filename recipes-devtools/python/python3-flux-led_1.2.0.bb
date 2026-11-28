SUMMARY = "A Python library to communicate with the flux_led smart bulbs"
HOMEPAGE = "https://github.com/Danielhiversen/flux_led"
LICENSE = "LGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6a600fd5e1d9cbde2d983680233ad02"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-pytest-runner-native"

SRC_URI[sha256sum] = "3cfb68df243bdc9bdde6a91e9d05960949de70b8a76fdb799b70021c54380c3d"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-async-timeout (>=3.0.0) \
    python3-webcolors \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-cov \
"

do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/pyproject.toml
    cat << 'EOF' >> ${D}${PTEST_PATH}/pyproject.toml

[tool.pytest.ini_options]
asyncio_mode = "auto"
EOF
}
