SUMMARY = "Asynchronous Python client for the Radio Browser APIt"
HOMEPAGE = "https://github.com/frenck/python-radios"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=b4ba024c7d738e1998f700f44772b3f6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "78a2ce349787e47d203fbd429f4f089e2db77314a7872eb6cb8e91c69ebd53ac"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiodns (>=4.0) \
    python3-aiohttp (>=3.0.0) \
    python3-awesomeversion (>=21.10.1) \
    python3-core (>=3.11) \
    python3-mashumaro (>= 3.10) \
    python3-orjson (>=3.9.8) \
    python3-probatio (>=0.13.0) \
    python3-pycares (>=5.0.0) \
    python3-yarl (>=1.6.0) \
"
