SUMMARY = "Asynchronous Python client for the GitHub API"
HOMEPAGE = "https://github.com/ludeeus/aiogithubapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0d02902304be192374ba1308a7a8ef54"

SRC_URI[md5sum] = "73fb4a7da69aada6401528e5082850fc"
SRC_URI[sha256sum] = "327c79287d10e985855c0b31702efad666b55ad223241efdf28af32695bd0858"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiosignal (>=1.1.2) \
    ${PYTHON_PN}-async-timeout (>=4.0.0a3) \
    ${PYTHON_PN}-attr (>=17.3.0) \
    ${PYTHON_PN}-charset-normalizer (>=2.0) \
    ${PYTHON_PN}-frozenlist (>=1.1.1) \
    ${PYTHON_PN}-multidict (>=4.5) \
    ${PYTHON_PN}-yarl (>=1.0) \
"
