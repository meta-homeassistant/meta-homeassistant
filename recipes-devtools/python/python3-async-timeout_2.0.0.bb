SUMMARY = "Timeout context manager for asyncio programs"
HOMEPAGE = "https://github.com/aio-libs/async_timeout/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit pypi setuptools3

SRC_URI[md5sum] = "36e75397e54c6b899ffabdfe295a9f7c"
SRC_URI[sha256sum] = "c17d8ac2d735d59aa62737d76f2787a6c938f5a944ecf768a8c0ab70b0dea566"

DEPENDS = "python3-pytest-runner-native python3"
