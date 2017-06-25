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

SRC_URI[md5sum] = "a1632df1a5840bed45bf1850dd434de0"
SRC_URI[sha256sum] = "0d152b87f6a97ad454c2a431766a33111e066008fdb404bfea71846213918ffd"

BBCLASSEXTEND = "native"
