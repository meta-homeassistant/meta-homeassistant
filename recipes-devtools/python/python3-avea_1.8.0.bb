SUMMARY = "Control an Elgato Avea bulb using python3"
HOMEPAGE = "https://github.com/k0rventen/avea"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da981d94d3cd3e010abf14da3a7e79a0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3a40e68a6ff38f4026928d05193a0fbdfcf5d5eb51a4533c2430cbd126c74cef"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-bleak python3-bleak-retry-connector"
