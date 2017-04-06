SUMMARY = "Simple API to access Netatmo weather station data from any python script"
HOMEPAGE = "https://github.com/jabesq/netatmo-api-python"
LICENSE = "CLOSED"
# TODO: Clarify license and fork situation:
#
# https://github.com/jabesq/netatmo-api-python
# https://github.com/philippelt/netatmo-api-python => PyPI

inherit pypi

SRC_URI = "https://github.com/jabesq/netatmo-api-python/archive/v${PV}.tar.gz"
S = "${WORKDIR}/netatmo-api-python-${PV}"

SRC_URI[md5sum] = "84469907e3f4d5320033694bebc59362"
SRC_URI[sha256sum] = "898cb2300f56f79a54a16c41f3cf0f1732b3550f26cb556648878dfd43f98693"

BBCLASSEXTEND = "native"
