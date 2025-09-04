SUMMARY = "Consume Server-Sent Event (SSE) messages with HTTPX."
HOMEPAGE = "https://github.com/florimondmanca/httpx-sse"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=847662516af24b720ff6168b0dfcc6b1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-setuptools-scm-native"
SRC_URI[sha256sum] = "8f44d34414bc7b21bf3602713005c5df4917884f76072479b21f68befa4ea26e"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "httpx_sse"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
