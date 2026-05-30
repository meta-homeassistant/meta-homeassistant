SUMMARY = "Asynchronous Python client for the GitHub API"
HOMEPAGE = "https://github.com/ludeeus/aiogithubapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0d02902304be192374ba1308a7a8ef54"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "71ee97ebb242378535551ede80605384d1d3536b83e68dae938ce201d06dac33"

inherit pypi python_hatchling

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8) \
    python3-backoff \
"
