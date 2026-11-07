SUMMARY = "Pytest Snapshot Test Utility"
HOMEPAGE = "https://github.com/tophat/syrupy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=48672cd576fa10fcb05f80eb40fff161"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7e584a8df4ede6dd3c1c44a77f9edc46186b6767a73dea6f0083044946839a59"

inherit pypi python_hatchling

RDEPENDS:${PN} = "python3-pytest"
