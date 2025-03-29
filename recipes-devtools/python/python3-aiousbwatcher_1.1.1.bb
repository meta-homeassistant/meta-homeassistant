SUMMARY = "Watch for USB devices to be plugged and unplugged"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e54da8273c4c98676209f659099d3531"
HOMEPAGE = "https://github.com/bluetooth-devices/aiousbwatcher"

SRC_URI[sha256sum] = "3a22a47b8dd1ca078bf8fbc3139cd16b7dabb11b901a1a96620246794baf679f"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aiousbwatcher"
RDEPENDS:${PN} = "python3-asyncinotify (>=4.2.0)"
