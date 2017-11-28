SUMMARY = "DTLSSocket is a cython wrapper for tinydtls with a Socket like interface"
HOMEPAGE = "https://git.fslab.de/jkonra2m/tinydtls-cython"
LICENSE = "EPL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0f496e8f7ed80c27693661195ebd8526"

SRC_URI += "file://0001-Pass-configure-options-from-bitbake.patch"

inherit pypi setuptools3

PYPI_PACKAGE = "DTLSSocket"

DEPENDS += "${PYTHON_PN}-cython-native"

CONFIGUREOPTS = " --build=${BUILD_SYS} --host=${HOST_SYS} --target=${TARGET_SYS}"
export CONFIGUREOPTS

SRC_URI[md5sum] = "bcef26a5320348905e3df61d65e983c3"
SRC_URI[sha256sum] = "7a256f47e68bd0289030c459fdce2f3decd0fc1a8efd147add87d36775e350ab"
