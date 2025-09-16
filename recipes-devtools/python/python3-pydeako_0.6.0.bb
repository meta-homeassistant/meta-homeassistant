SUMMARY = "Connect and interact with deako devices over the network locally"
HOMEPAGE = "https://github.com/DeakoLights/pydeako"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=300507c7f28cea83b550539b7815f073"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a0db5452d7bc3c94530309195586e6c72e1f928df9e743dde6041ebbef9ab04f"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
	python3-zeroconf \
"

PYPI_PACKAGE = "pydeako"
