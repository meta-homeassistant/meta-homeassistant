SUMMARY = "Ordered YAML: drop-in replacement for PyYAML which preserves dict ordering"
HOMEPAGE = "https://github.com/wimglenn/oyaml"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a96e837687c43d497cda6902f81e6c84"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ed8fc096811f4763e1907dce29c35895d6d5936c4d0400fe843a91133d4744ed"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-pyyaml"

PYPI_PACKAGE = "oyaml"
