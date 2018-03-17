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

SRC_URI[md5sum] = "1428aa6f23d79df77099e7a5788f3156"
SRC_URI[sha256sum] = "1fffdeaec648c85d1a9a0069df5cb5b4a1c435d9a91769689a0ccb86bcaff1b3"

BBCLASSEXTEND = "native"
