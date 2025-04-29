SUMMARY = "Fast serialization library on top of dataclasses"
HOMEPAGE = "https://github.com/Fatal1ty/mashumaro"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e7bdee652937974f23d94be386c358bd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/Fatal1ty/mashumaro.git;protocol=https;branch=master"
SRC_URI[sha256sum] = "169f0290253b3e6077bcb39c14a9dd0791a3fdedd9e286e536ae561d4ff1975b"
SRCREV = "e945ee4319db49da9f7b8ede614e988cc8c8956b"

inherit python_setuptools_build_meta ptest-python-pytest

S = "${WORKDIR}/git"

PACKAGECONFIG[orjson] = ",,,python3-orjson"
PACKAGECONFIG[yaml] = ",,,python3-pyyaml"

RDEPENDS:${PN} += "\
    python3-typing-extensions (>=4.1.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-msgpack \
    python3-tomli-w \
"
