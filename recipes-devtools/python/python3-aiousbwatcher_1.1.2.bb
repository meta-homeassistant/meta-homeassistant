SUMMARY = "Watch for USB devices to be plugged and unplugged"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e54da8273c4c98676209f659099d3531"
HOMEPAGE = "https://github.com/bluetooth-devices/aiousbwatcher"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "908919fed3b5d6b5b0a26f7aea82a5f45c6a6205789dcb39348abc34a4f06ebe"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "python3-asyncinotify (>=4.2.0)"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-cov \
"
