SUMMARY = "Python client for controlling the Geocaching API"
HOMEPAGE = "https://github.com/Sholofly/geocachingapi-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=65ecb7e1f43e585705ecc250caadc0a1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b91565af7b476707c60cc71dda89c9ed805e5618579e54b0af59c77a34d33f4d"

DEPENDS = "python3-setuptools-scm-native"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.7.4) \
    python3-backoff (>=1.9.0) \
    python3-reverse-geocode (>=1.6.5) \
    python3-yarl \
"

PYPI_PACKAGE = "geocachingapi"
