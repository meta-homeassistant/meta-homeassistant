SUMMARY = "A library to retrieve coordinates from an google account that has been shared locations of other accounts."
HOMEPAGE = "https://github.com/costastf/locationsharinglib"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b36f8cdefadd0e8c977d41f521c50c29"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6abe7f8320e76f2d1a71eaaa1def254d068769f3ae6fe20f2a096672de311063"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-cachetools (>=5.3.2) \
    python3-coloredlogs (>=15.0.1) \
    python3-pytz \
    python3-requests (>=2.31.0) \
"
