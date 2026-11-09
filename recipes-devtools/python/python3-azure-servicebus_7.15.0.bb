SUMMARY = "Microsoft Azure Service Bus Client Library for Python"
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "62c73f3d9efbaf0089a375adc5ef992ffe6d7d0b1218b8462265aa30ad352c3e"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-azure-core (>=1.28.0) \
    python3-isodate (>=0.6.0) \
    python3-typing-extensions (>=4.6.0) \
"

DEPENDS += "python3-wheel-native"
