SUMMARY = "Communicate with Dovado router"
HOMEPAGE = "https://github.com/molobrakos/dovado"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;beginline=11;endline=11;md5=dd52d74eb9eabb494ff44e784948e53a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "cb91135525e2fa5a0f2da3e1e9b57b264870605cd27e54ccb07c24f260dcc785"

DEPENDS = "python3-standard-telnetlib-native"

inherit pypi setuptools3

PACKAGECONFIG ?= "console"
PACKAGECONFIG[console] = ",,,python3-docopt"

RDEPENDS:${PN} += "python3-netifaces"

RPROVIDES:${PN} = "dovado"
