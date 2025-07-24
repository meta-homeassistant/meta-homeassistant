SUMMARY = "wrapper around different bluetooth low energy backends"
HOMEPAGE = "https://github.com/ChristianKuehnel/btlewrap"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c25dca6f05d3d0d952c7fe9373c8b429"

SRC_URI[sha256sum] = "f3befbeed3a6c5abf99dc0d6bbaab570868a5175e52252d53c45bd78c85cc294"

inherit pypi setuptools3
#PACKAGECONFIG ?= "bluepy pygatt testing"
PACKAGECONFIG[bluepy] = ",,,python3-bluepy"
PACKAGECONFIG[pygatt] = ",,,python3-pygatt"
PACKAGECONFIG[testing] = ",,,python3-pytest"

PYPI_PACKAGE = "btlewrap"
