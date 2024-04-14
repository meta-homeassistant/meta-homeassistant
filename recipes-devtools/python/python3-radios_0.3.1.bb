SUMMARY = "Asynchronous Python client for the Radio Browser APIt"
HOMEPAGE = "https://github.com/frenck/python-radios"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=70c1553aadb543ba3f430ad86244f922"

SRC_URI[sha256sum] = "717b62e944a277313a7c8c407e1902ac2c312fa70f9f957a42450d3934b3e2ca"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiodns (>=3.0) \
    python3-aiohttp (>=3.0.0) \
    python3-awesomeversion (>=21.10.1) \
    python3-backoff (>=1.9.0) \
    python3-cachetools (>=4.0.0) \
    python3-mashumaro (>= 3.10) \
    python3-orjson (>=3.9.8) \
    python3-pycountry (>=23.0.0) \
    python3-core (>=3.11) \
    python3-yarl (>=1.6.0) \
"
