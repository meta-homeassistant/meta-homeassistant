SUMMARY = "Asyncio bridge to the standard sqlite3 module"
HOMEPAGE = "https://github.com/omnilib/aiosqlite"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f0c422eaa1f23d09f8203dc0af3e2d54"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "043e0bd78d32888c0a9ca90fc788b38796843360c855a7262a532813133a0650"

inherit pypi python_flit_core
