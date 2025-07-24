SUMMARY = "Module for accessing APRS-IS and parsing APRS packets"
HOMEPAGE = "https://github.com/rossengeorgiev/aprs-python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c20d2568ab8728a0526b4c95952c6022433d462674abdfb0fd86b2e50ed3c097"

inherit pypi setuptools3

PYPI_PACKAGE = "aprslib"
