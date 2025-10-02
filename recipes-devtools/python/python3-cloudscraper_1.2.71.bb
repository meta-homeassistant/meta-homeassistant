SUMMARY = "A Python module to bypass Cloudflare's anti-bot page."
HOMEPAGE = "https://github.com/venomous/cloudscraper"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=98c45be7641881cca37b9a66a65a1a6e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"
SRC_URI[sha256sum] = "429c6e8aa6916d5bad5c8a5eac50f3ea53c9ac22616f6cb21b18dcc71517d0d3"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-pyparsing (>=2.4.7) \
    python3-requests (>=2.9.2) \
    python3-requests-toolbelt (>=0.9.1) \
"

PYPI_PACKAGE = "cloudscraper"
