SUMMARY = "Library to communicate with Govee local API"
HOMEPAGE = "https://github.com/Galorhallen/govee-local-api"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9aeb104644718d702b9b5462aa990cb24d88c6b260aa23c4c8c8e5191c55c83f"

inherit pypi python_poetry_core

PYPI_PACKAGE = "govee_local_api"
