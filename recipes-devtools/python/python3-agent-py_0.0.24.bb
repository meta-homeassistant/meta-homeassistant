SUMMARY = "A python wrapper around the Agent REST API."
HOMEPAGE = "https://github.com/ispysoftware/agent-py"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=f0a3e4a2554ebb89c046c93d45d8e4bc"

SRC_URI[sha256sum] = "73a0cfdc1555aa7f07d3ee96cb3ce48eb91df2254c44088c810fbdb0ffd7d395"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp"

PYPI_PACKAGE = "agent-py"
