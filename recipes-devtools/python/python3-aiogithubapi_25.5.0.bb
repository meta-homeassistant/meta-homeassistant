SUMMARY = "Asynchronous Python client for the GitHub API"
HOMEPAGE = "https://github.com/ludeeus/aiogithubapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0d02902304be192374ba1308a7a8ef54"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "2f598ec387258ba818994400bfad781bba6315b263774bd1fd3dcfabec02ce51"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8) \
    python3-async-timeout (>=4) \
    python3-backoff \
"
