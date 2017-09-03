SUMMARY = "Client-Server SDK for Matrix"
HOMEPAGE = "https://github.com/matrix-org/matrix-python-sdk"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"

inherit pypi

S = "${WORKDIR}/matrix-python-sdk-${PV}"

SRC_URI[md5sum] = "d481607d730abe24c235cb5e3ccbf68c"
SRC_URI[sha256sum] = "38428949978065e56dd09ec35356784b59e982e1644a7fbb06994323fa2d7d96"
