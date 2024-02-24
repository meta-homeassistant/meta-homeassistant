SUMMARY = "Asynchronous Python client for the GitHub API"
HOMEPAGE = "https://github.com/ludeeus/aiogithubapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0d02902304be192374ba1308a7a8ef54"

SRC_URI[md5sum] = "73fb4a7da69aada6401528e5082850fc"
SRC_URI[sha256sum] = "327c79287d10e985855c0b31702efad666b55ad223241efdf28af32695bd0858"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiosignal (>=1.1.2) \
    python3-async-timeout (>=4.0.0a3) \
    python3-attrs (>=17.3.0) \
    python3-charset-normalizer (>=2.0) \
    python3-frozenlist (>=1.1.1) \
    python3-multidict (>=4.5) \
    python3-yarl (>=1.0) \
"
