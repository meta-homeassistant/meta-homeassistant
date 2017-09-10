SUMMARY = "Timeout context manager for asyncio programs"
HOMEPAGE = "https://github.com/aio-libs/async_timeout/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit pypi setuptools3

SRC_URI[md5sum] = "a3c010b25cfad96538578bb3c153ce5e"
SRC_URI[sha256sum] = "f4651f122a9877049930ce31a8422bc202a47937627295fe5e411b2c2083481f"

DEPENDS = "python3-pytest-runner-native python3"
