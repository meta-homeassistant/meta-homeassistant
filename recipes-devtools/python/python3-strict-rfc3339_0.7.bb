SUMMARY = "Strict, simple, lightweight RFC3339 functions"
HOMEPAGE = "http://www.danielrichman.co.uk/libraries/strict-rfc3339.html"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8f0e2cd40e05189ec81232da84bd6e1a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5cad17bedfc3af57b399db0fed32771f18fc54bbd917e85546088607ac5e1277"

inherit pypi setuptools3

PYPI_PACKAGE = "strict-rfc3339"
