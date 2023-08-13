SUMMARY = "Asynchronous Python client for the Radio Browser APIt"
HOMEPAGE = "https://github.com/frenck/python-radios"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=7ec84bf604ae689a7c7cbdfee8003a61"

SRC_URI[md5sum] = "0a53e200ad56d5a9d83c57e206365f94"
SRC_URI[sha256sum] = "9ac0aaffc1476d47d6766b2adb35aea5039713aec6d20669ff008bffaa4d599e"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiodns (>=3.0) \
    ${PYTHON_PN}-aiohttp (>=3.0.0) \
    ${PYTHON_PN}-awesomeversion (>=21.10.1) \
    ${PYTHON_PN}-backoff (>=1.9.0) \
    ${PYTHON_PN}-cachetools (>=4.0.0) \
    ${PYTHON_PN}-pycountry (>=22.1.10) \
    ${PYTHON_PN}-pydantic (>=1.9) \
    ${PYTHON_PN}-yarl (>=1.6.0) \
"
