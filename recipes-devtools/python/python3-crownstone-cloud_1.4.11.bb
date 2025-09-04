SUMMARY = "Asynchronous Python library to get data from the cloud, and switch Crownstones."
HOMEPAGE = "https://github.com/Crownstone-Community/crownstone-lib-python-cloud"
LICENSE = "LGPL-3.0-only & MIT & Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=ee74614898feab20d6ab5bc151a9b20d \
                    file://LICENSE-LGPL;md5=e6a600fd5e1d9cbde2d983680233ad02 \
                    file://LICENSE-MIT;md5=417c5f11876a875e4b041c01250ab49d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b3ce292b9dae32ea7141f74c95d575e15de78fec9592ed55c35dc2457e28d3c5"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.7) \
    python3-certifi \
"

PYPI_PACKAGE = "crownstone_cloud"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
