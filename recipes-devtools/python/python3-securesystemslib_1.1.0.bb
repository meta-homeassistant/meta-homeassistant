SUMMARY = "A library that provides cryptographic and general-purpose routines for Secure Systems Lab projects at NYU"
HOMEPAGE = "https://github.com/secure-systems-lab/securesystemslib"
LICENSE = "MIT & CC0-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e9703d169911cdb29305f88411c78717 \
                    file://securesystemslib/_vendor/ed25519/LICENSE;md5=65d3616852dbf7b1a6d4b53b00626032 \
"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "27143a8e04b5573636f260f21d7e26b48bcedcf394e6f74ec31e9a5287e0c38b"

inherit pypi python_hatchling

PYPI_PACKAGE = "securesystemslib"

PACKAGES += "\
    ${PN}-crypto \
"

RDEPENDS:${PN} = "\
    bash \
    python3-cryptography (>=40.0.0) \
"
