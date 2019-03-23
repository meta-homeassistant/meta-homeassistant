SUMMARY = "YAML parser/emitter that supports roundtrip preservation of comments, seq/map flow style, and map key order"
HOMEPAGE = "https://bitbucket.org/ruamel/yaml"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=caf8bd842440b537c044e131785a4666"

PYPI_PACKAGE = "ruamel.yaml"

inherit pypi

SRC_URI[md5sum] = "1508488c85795ade0bd309e1626f2696"
SRC_URI[sha256sum] = "86d034aa9e2ab3eacc5f75f5cd6a469a2af533b6d9e60ea92edbba540d21b9b7"

do_install_prepend() {
    export RUAMEL_NO_PIP_INSTALL_CHECK=1
}
