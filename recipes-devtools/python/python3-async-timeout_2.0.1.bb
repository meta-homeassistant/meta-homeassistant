SUMMARY = "Timeout context manager for asyncio programs"
HOMEPAGE = "https://github.com/aio-libs/async_timeout/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit pypi setuptools3

SRC_URI[md5sum] = "9dfa03c6efc1dc02411ec791179add59"
SRC_URI[sha256sum] = "00cff4d2dce744607335cba84e9929c3165632da2d27970dbc55802a0c7873d0"

DEPENDS = "python3-pytest-runner-native python3"
