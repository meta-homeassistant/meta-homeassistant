SUMMARY = "An implementation of the Debug Adapter Protocol for Python"
HOMEPAGE = "https://github.com/microsoft/debugpy/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7b6b095fe2a2e2b66cb08d295b605789"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7cd287184318416850aa8b60ac90105837bb1e59531898c07569d197d2ed5322"

inherit pypi python_setuptools_build_meta
