SUMMARY = "Timeout context manager for asyncio programs"
HOMEPAGE = "https://github.com/aio-libs/async_timeout/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit pypi setuptools3

SRC_URI[md5sum] = "e71f9b197498f917864e29af7a5defa0"
SRC_URI[sha256sum] = "380e9bfd4c009a14931ffe487499b0906b00b3378bb743542cfd9fbb6d8e4657"

DEPENDS = "python3-pytest-runner-native python3"
