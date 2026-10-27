SUMMARY = "Asynchronous Python client for BSBLAN API"
DESCRIPTION = "Asynchronous Python client for the BSBLAN API."
HOMEPAGE = "https://github.com/liudger/python-bsblan"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=710ba3a34eb2efe583dd46d798df6ed1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8a9c7d2fe5ad7bd0f35adc4e9ec5c2276710e65da1e277d843e0610c7ca75652"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN}-ptest += "\
    python3-aresponses \
    python3-covdefaults \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-xdist \
"

do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
    sed -i 's|"src/bsblan"|"bsblan"|' ${D}${PTEST_PATH}/pyproject.toml
}

RDEPENDS:${PN}:append = " \
    python3-aiohttp (>=3.8.1) \
    python3-backoff (>=2.2.1) \
    python3-packaging (>=21.3) \
    python3-pydantic (>=2.0) \
    python3-yarl (>=1.7.2) \
"
