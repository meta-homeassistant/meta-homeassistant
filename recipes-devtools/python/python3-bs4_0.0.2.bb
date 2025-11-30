SUMMARY = "Dummy package for Beautiful Soup (beautifulsoup4)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=f8476a3be0088ff877585f896845c0da"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "a48685c58f50fe127722417bae83fe6badf500d54b55f7e39ffe43b798653925"

inherit pypi python_hatchling

RDEPENDS:${PN} += "\
    python3-beautifulsoup4 \ 
"
