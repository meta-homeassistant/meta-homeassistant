SUMMARY = "Asynchronous Python client for the Radio Browser APIt"
HOMEPAGE = "https://github.com/frenck/python-radios"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=d12eb6585c37cdb43a60b053ee6ba32d"

SRC_URI[sha256sum] = "617c8f3dfb5824fd268cfb9662967e76e4b7467285f4e22de90973296ca5bd10"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiodns (>=3.0) \
    ${PYTHON_PN}-aiohttp (>=3.0.0) \
    ${PYTHON_PN}-awesomeversion (>=21.10.1) \
    ${PYTHON_PN}-backoff (>=1.9.0) \
    ${PYTHON_PN}-cachetools (>=4.0.0) \
    ${PYTHON_PN}-mashumaro (>= 3.10) \
    ${PYTHON_PN}-pycountry (>=22.1.10) \
    ${PYTHON_PN}-core (>=3.11) \
    ${PYTHON_PN}-yarl (>=1.6.0) \
"
