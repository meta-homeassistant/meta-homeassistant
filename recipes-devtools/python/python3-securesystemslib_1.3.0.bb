SUMMARY = "A library that provides cryptographic and general-purpose routines for Secure Systems Lab projects at NYU"
HOMEPAGE = "https://github.com/secure-systems-lab/securesystemslib"
LICENSE = "MIT & CC0-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e9703d169911cdb29305f88411c78717 \
                    file://securesystemslib/_vendor/ed25519/LICENSE;md5=65d3616852dbf7b1a6d4b53b00626032 \
"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "5b53e5989289d97fa42ed7fde1b4bad80985f15dba8c774c043b395a90c908e5"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "securesystemslib"

PACKAGES += "\
    ${PN}-crypto \
"

RDEPENDS:${PN} = "\
    bash \
    python3-cryptography (>=40.0.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-asn1crypto \
"
