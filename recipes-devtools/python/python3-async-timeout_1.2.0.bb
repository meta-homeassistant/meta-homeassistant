SUMMARY = "Timeout context manager for asyncio programs"
HOMEPAGE = "https://github.com/aio-libs/async_timeout/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit pypi setuptools3

SRC_URI[md5sum] = "b9fc198be2e415e6786da596091abe40"
SRC_URI[sha256sum] = "0652d108c0156ae5ac94d99f53a6bdd039b0c076346ff8f58c9a1551fac17a19"

DEPENDS = "python3-pytest-runner-native python3"
