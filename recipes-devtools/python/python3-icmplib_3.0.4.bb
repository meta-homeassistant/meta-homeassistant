SUMMARY = "Easily forge ICMP packets and make your own ping and traceroute."
HOMEPAGE = "https://github.com/ValentinBELYN/icmplib"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3000208d539ec061b899bce1d9ce9404"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "57868f2cdb011418c0e1d5586b16d1fabd206569fe9652654c27b6b2d6a316de"

inherit pypi setuptools3

PYPI_PACKAGE = "icmplib"
