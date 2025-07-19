SUMMARY = "Read key-value pairs from a .env file and set them as environment variables"
HOMEPAGE = "https://github.com/theskumar/python-dotenv"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e914cdb773ae44a732b392532d88f072"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a8a6399716257f45be6a007360200409fce5cda2661e3dec71d23dc15f6189ab"

inherit pypi setuptools3

# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "cli"
PACKAGECONFIG[cli] = ",,,python3-click"

PYPI_PACKAGE = "python_dotenv"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
