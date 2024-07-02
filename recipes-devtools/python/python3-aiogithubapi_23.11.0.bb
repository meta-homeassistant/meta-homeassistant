SUMMARY = "Asynchronous Python client for the GitHub API"
HOMEPAGE = "https://github.com/ludeeus/aiogithubapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0d02902304be192374ba1308a7a8ef54"

SRC_URI[sha256sum] = "773230c72c62c04ef78dcde5d94302bb22e20005f7dbad99e6425d4c379d82c2"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8) \
    python3-backoff \
    python3-sigstore \
"
