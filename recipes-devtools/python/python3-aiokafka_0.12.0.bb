SUMMARY = "Kafka integration with asyncio"
HOMEPAGE = "https://github.com/aio-libs/aiokafka"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4b3c56bc0457c5f13d4d549c117e69aa"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "62423895b866f95b5ed8d88335295a37cc5403af64cb7cb0e234f88adc2dff94"

inherit pypi python_setuptools_build_meta cython

#PACKAGECONFIG ?= "all gssapi lz4 snappy zstd"
PACKAGECONFIG[all] = ",,,python3-cramjam python3-gssapi"
PACKAGECONFIG[gssapi] = ",,,python3-gssapi"
PACKAGECONFIG[lz4] = ",,,python3-cramjam"
PACKAGECONFIG[snappy] = ",,,python3-cramjam"
PACKAGECONFIG[zstd] = ",,,python3-cramjam"

RDEPENDS:${PN} += "\
    python3-async-timeout \
    python3-packaging \
    python3-typing-extensions (>=4.10.0) \
"

PYPI_PACKAGE = "aiokafka"
