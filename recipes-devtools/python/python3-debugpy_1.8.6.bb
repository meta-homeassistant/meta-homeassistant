SUMMARY = "An implementation of the Debug Adapter Protocol for Python"
HOMEPAGE = "https://github.com/microsoft/debugpy/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7b6b095fe2a2e2b66cb08d295b605789"

SRC_URI[sha256sum] = "c931a9371a86784cee25dec8d65bc2dc7a21f3f1552e3833d9ef8f919d22280a"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE_EXT = "zip"
