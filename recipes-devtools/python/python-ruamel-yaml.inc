SUMMARY = "YAML parser/emitter that supports roundtrip preservation of comments, seq/map flow style, and map key order"
HOMEPAGE = "https://bitbucket.org/ruamel/yaml"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=caf8bd842440b537c044e131785a4666"

PYPI_PACKAGE = "ruamel.yaml"

inherit pypi

SRC_URI[md5sum] = "dd811a8f09dc0e622ad19a42508da7c1"
SRC_URI[sha256sum] = "8e42f3067a59e819935a2926e247170ed93c8f0b2ab64526f888e026854db2e4"

do_install_prepend() {
    export RUAMEL_NO_PIP_INSTALL_CHECK=1
}
