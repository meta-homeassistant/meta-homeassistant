SUMMARY = "Tests and Documentation Done by Example."
HOMEPAGE = "https://github.com/timothycrosley/examples/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=42c5f81738a66f0770ad233655b4d933"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Use-correct-class-for-compilation.patch"
SRC_URI[sha256sum] = "f29ba443f158bb47913ac21f098306a9749ed459a2290540ff1f86baac074597"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "python3-pydantic (>=0.32.2)"

PYPI_PACKAGE = "examples"
