SUMMARY = "Asyncio bridge to the standard sqlite3 module"
HOMEPAGE = "https://github.com/omnilib/aiosqlite"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f0c422eaa1f23d09f8203dc0af3e2d54"

SRC_URI[sha256sum] = "6d35c8c256637f4672f843c31021464090805bf925385ac39473fb16eaaca3d7"

inherit pypi python_flit_core

RDEPENDS:${PN} = "python3-typing-extensions"
