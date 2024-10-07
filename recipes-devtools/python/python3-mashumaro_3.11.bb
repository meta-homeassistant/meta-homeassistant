SUMMARY = "Fast serialization library on top of dataclasses"
HOMEPAGE = "https://github.com/Fatal1ty/mashumaro"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e7bdee652937974f23d94be386c358bd"

SRC_URI[sha256sum] = "b0b2443be4bdad29bb209d91fe4a2a918fbd7b63cccfeb457c7eeb567db02f5e"

inherit pypi python_setuptools_build_meta

PACKAGECONFIG[msgpack] = ",,,python3-msgpack"
PACKAGECONFIG[orjson] = ",,,python3-orjson"
PACKAGECONFIG[toml] = ",,,python3-tomli-w"
PACKAGECONFIG[tomlpython-version-smaller-3-dot-11] = ",,,python3-tomli"
PACKAGECONFIG[yaml] = ",,,python3-pyyaml"

RDEPENDS:${PN} += "\
    python3-typing-extensions (>=4.1.0) \
"

PYPI_PACKAGE = "mashumaro"
