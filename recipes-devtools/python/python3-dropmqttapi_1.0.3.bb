SUMMARY = "MQTT API for DROP water management products"
HOMEPAGE = "https://github.com/ChandlerSystems/dropmqttapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a11dde836df1c6d4e6fcd6e70c22d778"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "96b6058eeac4c7598b5dcc3d4a9afc22f7d92397db56862dd905f9fe8a7a9aa1"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "dropmqttapi"
