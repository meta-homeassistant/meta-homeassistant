SUMMARY = "Pytest Snapshot Test Utility"
HOMEPAGE = "https://github.com/tophat/syrupy"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a74db8ae475d2bd439d60ff9df4e3e3"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b7d0fcadad80a7d2f6c4c71917918e8ebe2483e8c703dfc8d49cdbb01081f9a4"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "python3-pytest"
