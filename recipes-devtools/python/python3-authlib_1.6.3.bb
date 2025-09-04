SUMMARY = "The ultimate Python library in building OAuth and OpenID Connect servers and clients."
HOMEPAGE = "https://github.com/authlib/authlib"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ec053ca028e37ec79d3da3af34976d48"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9f7a982cc395de719e4c2215c5707e7ea690ecf84f1ab126f28c053f4219e610"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "python3-cryptography"
