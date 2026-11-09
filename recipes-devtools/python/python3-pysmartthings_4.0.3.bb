SUMMARY = "Asynchronous Python client for SmartThings."
HOMEPAGE = "https://github.com/pySmartThings/pysmartthings"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c11f6785f26e567a799a64201e1ce6c3"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "58c4b7e21ff4d1351f425d70191d61f558f04c5de4670c576b4e4d43e1cbc6d5"

inherit pypi python_hatchling


RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.10) \
    python3-yarl (>=1.6.0) \
"
