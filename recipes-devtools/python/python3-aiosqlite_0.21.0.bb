SUMMARY = "Asyncio bridge to the standard sqlite3 module"
HOMEPAGE = "https://github.com/omnilib/aiosqlite"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f0c422eaa1f23d09f8203dc0af3e2d54"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "131bb8056daa3bc875608c631c678cda73922a2d4ba8aec373b19f18c17e7aa3"

inherit pypi python_flit_core

RDEPENDS:${PN} = "python3-typing-extensions"
