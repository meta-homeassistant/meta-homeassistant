SUMMARY = "Library to communicate with Govee local API"
HOMEPAGE = "https://github.com/Galorhallen/govee-local-api"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-pyproject.toml-allow-uv_build-0.13.patch"
SRC_URI[sha256sum] = "0cd47ca23484706e19f544bbf658ccdbb207a23abb4d720775aa69e198ec895b"

inherit pypi python_uv_build
