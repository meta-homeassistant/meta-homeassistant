SUMMARY = "Utilities for handling packages."
HOMEPAGE = "https://github.com/domdfcoding/shippinglabel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c61fe6187288c5c2e41810d0457f1e89"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com"

SRC_URI[sha256sum] = "25c0c3194c011c0355dff8f56cc0b31688f693b209f5849d44991d8a2ec91f2f"

inherit pypi python_hatchling

BBCLASSEXTEND = "native nativesdk"
