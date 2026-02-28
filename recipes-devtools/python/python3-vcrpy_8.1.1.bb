SUMMARY = "Automatically mock your HTTP interactions to simplify and speed up testing"
HOMEPAGE = "https://github.com/kevin1024/vcrpy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=adb3f4813aa9f735e6e58b621b81d4b1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "58e3053e33b423f3594031cb758c3f4d1df931307f1e67928e30cf352df7709f"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "vcrpy"
RDEPENDS:${PN} = "\
    python3-pyyaml \
    python3-wrapt \
"

RDEPENDS:${PN}-ptest = "\
    python3-aiohttp \
    python3-boto3 \
    python3-cryptography \
    python3-httpbin \
    python3-httpcore \
    python3-httplib2 \
    python3-httpx \
    python3-pytest-aiohttp \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-httpbin \
    python3-requests \
    python3-tornado \
    python3-urllib3 \
    python3-werkzeug \
    ${PN} \
"
