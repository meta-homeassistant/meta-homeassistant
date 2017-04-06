SUMMARY = "An implementation of the WebSocket Protocol (RFC 6455)"
HOMEPAGE = "https://github.com/aaugustin/websockets"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dd6fe435c697ec9f28d4bbb38b955e64"

inherit pypi setuptools3

SRC_URI += "file://explicit-uft8.patch"

SRC_URI[md5sum] = "a01f53b7b8bfe339f9cceb2c86c01bd0"
SRC_URI[sha256sum] = "305ab7fdd86afd08c2723461c949e153f7b01233f95a108619a15e41b7a74c93"
