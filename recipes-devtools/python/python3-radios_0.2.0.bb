SUMMARY = "Asynchronous Python client for the Radio Browser APIt"
HOMEPAGE = "https://github.com/frenck/python-radios"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=d12eb6585c37cdb43a60b053ee6ba32d"

SRC_URI[sha256sum] = "617c8f3dfb5824fd268cfb9662967e76e4b7467285f4e22de90973296ca5bd10"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiodns (>=3.0) \
    python3-aiohttp (>=3.0.0) \
    python3-awesomeversion (>=21.10.1) \
    python3-backoff (>=1.9.0) \
    python3-cachetools (>=4.0.0) \
    python3-mashumaro (>= 3.10) \
    python3-pycountry (>=22.1.10) \
    python3-core (>=3.11) \
    python3-yarl (>=1.6.0) \
"
