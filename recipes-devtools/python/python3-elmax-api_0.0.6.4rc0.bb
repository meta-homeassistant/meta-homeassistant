SUMMARY = "Asynchronous API Library to work with Elmax devices"
HOMEPAGE = "https://github.com/albertogeniola/elmax-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "454c872386c59d1ed8f2e898765eb5acbf8625c43534ac58ea68778d64961d19"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-httpx (>=0.18.0) \
    python3-pyjwt (>=1.7.1) \
    python3-websockets (>=13.0) \
    python3-yarl (>=1.6.3) \
"

FILES:${PN}-dbg += "/usr/requirements.txt"

PYPI_PACKAGE = "elmax_api"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
