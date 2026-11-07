SUMMARY = "Asynchronous Python client for getting forecast solar information"
HOMEPAGE = "https://github.com/home-assistant-libs/forecast_solar"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b32893bb58475a5fc11ecaf8f9fe064"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "cc84a042a4b1076bc9dc25932472d267f72cdca70a4a8b3c74ac6672644d1a66"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-yarl (>=1.6.0) \
"
