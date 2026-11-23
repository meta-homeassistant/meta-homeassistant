SUMMARY = "Asynchronous Python client for Elgato Lights."
HOMEPAGE = "https://github.com/frenck/python-elgato"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=5;endline=5;md5=134f1026f0de92fd30e71976590a2868"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "21efb43fa0666d4486959ed6324b9e153fcd2777f57b865f1441c70a1e4d2135"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-cryptography \
    python3-mashumaro (>=3.10) \
    python3-orjson (>=3.9.8) \
    python3-yarl (>=1.6.0) \
"
