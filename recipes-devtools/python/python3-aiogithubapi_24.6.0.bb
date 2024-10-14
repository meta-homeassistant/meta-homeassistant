SUMMARY = "Asynchronous Python client for the GitHub API"
HOMEPAGE = "https://github.com/ludeeus/aiogithubapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0d02902304be192374ba1308a7a8ef54"

SRC_URI[sha256sum] = "6506a05608968c9071bb28aa64ce87d5473d4ce16e3cc3b4fea06dcba2966b80"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8) \
    python3-async-timeout (>=4) \
    python3-backoff \
"
