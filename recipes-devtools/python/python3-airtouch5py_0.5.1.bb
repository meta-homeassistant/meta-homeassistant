SUMMARY = "Python client for the airtouch 5"
HOMEPAGE = "https://github.com/danzel/airtouch5py"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "b110b30cacda1cd4a5b2301206d3f0c7bd74df4e48c444b6d1171b91e836dd3f"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-bitarray (>=3.4.2) \
    python3-crc (>=7.1.0) \
"
