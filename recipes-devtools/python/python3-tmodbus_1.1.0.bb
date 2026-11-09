SUMMARY = "A modern, strongly typed Modbus client library."
DESCRIPTION = "Modern Python Modbus library that is fully typed and well tested."
HOMEPAGE = "https://github.com/wlcrs/tmodbus"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e174c4c4dde346bb30d60a5c868e491b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5ec0f216c75bf33f9c932569ad377e8e926be033cc300b90c48d4f4aff6b7b37"

inherit pypi python_hatchling ptest-python-pytest

DEPENDS += "python3-hatch-vcs-native"

RDEPENDS:${PN} += "\
    python3-tenacity \
"

RDEPENDS:${PN}-ptest += "\
    python3-cryptography \
    python3-pytest-asyncio \
    python3-serialx \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
    # The test expects the TLS handshake to accept a client certificate with
    # duplicate extensions. OpenSSL 4.1 rejects such certificates as RFC 5280
    # requires (https://github.com/openssl/openssl/pull/30233). Reported as
    # https://github.com/wlcrs/tmodbus/issues/164.
    sed -i '/^\[tool\.pytest\.ini_options\]/a addopts = "--deselect tests/server/test_async_tcp_security.py::test_tls_server_cert_duplicate_role_uses_first"' ${D}${PTEST_PATH}/pyproject.toml
}
