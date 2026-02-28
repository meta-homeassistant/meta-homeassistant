SUMMARY = "Client library to download and publish models, datasets and other repos on the huggingface.co hub"
HOMEPAGE = "https://github.com/huggingface/huggingface_hub"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5f86cd48f27131cdbf2882699cbdf7a67dd4cbe89a81edfdc31211f42e4a5fd1"
SRC_URI = "git://github.com/huggingface/huggingface_hub;protocol=https;tag=v${PV};branch=v1.3-release"
SRCREV = "0d8d045a9f933331f33e609e578c5452b944495c"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-filelock \
    python3-fsspec \
    python3-hf-xet \
    python3-httpx \
    python3-packaging \
    python3-pyyaml \
    python3-shellingham \
    python3-tqdm \
    python3-typing-extensions \
"

RDEPENDS:${PN}-ptest += " \
    python3-pytest-cov \
    python3-pytest-env \
    python3-pytest-xdist \
    python3-pytest-vcr \
    python3-pytest-asyncio \
    python3-pytest-rerunfailures \
    python3-pytest-mock \
    python3-urllib3 \
    python3-soundfile \
    python3-pillow \
    python3-numpy \
    python3-fastapi \
    python3-jedi \
"

PYPI_PACKAGE = "huggingface_hub"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
