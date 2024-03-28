SUMMARY = "DIDL-Lite (Digital Item Declaration Language) tools for Python"
HOMEPAGE = "https://github.com/StevenLooman/python-didl-lite"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi setuptools3

SRC_URI[md5sum] = "cdd3cc450a767fc2aec1370c404f5a60"
SRC_URI[sha256sum] = "88c0641d3140f7b05f1efd93f7c481fc62aa50d1e05e17f0e0a15bee025c4af1"

RDEPENDS:${PN} = "\
	python3-defusedxml (>=0.6.0) \
"
