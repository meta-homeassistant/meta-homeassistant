SUMMARY = "Wrapper of psutil that removes reliance on globals "
HOMEPAGE = "https://github.com/home-assistant-libs/psutil-home-assistant"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"

SRC_URI[md5sum] = "f6116c9ee248e517c02070aec7add6a2"
SRC_URI[sha256sum] = "ebe4f3a98d76d93a3140da2823e9ef59ca50a59761fdc453b30b4407c4c1bdb8"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-psutil \
"
