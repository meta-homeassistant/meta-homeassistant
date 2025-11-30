SUMMARY = "Asynchronous Python client providing Open Data information of Amsterdam"
HOMEPAGE = "https://github.com/klaasnicolaas/python-odp-amsterdam"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6a79ffb14a17cf2e4c64288321317372"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f959e9400b3a2f0c33c3cb82e1577a5ea16bc82fc3cc0aec8d702850268631d5"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-yarl (>=1.6.0) \
"

PYPI_PACKAGE = "odp_amsterdam"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
