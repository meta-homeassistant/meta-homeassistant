SUMMARY = "Unofficial package to access Bring! shopping lists API."
HOMEPAGE = "https://github.com/miaucl/bring-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a904c7a61349b66aabdf1e0870cfa3f4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "af139e7b7d3cbfa444c27bf06b0f56b1499a6c0bbbc7c41519d732afeae0cf19"
SRC_URI = "git://github.com/miaucl/bring-api;protocol=https;tag=${PV};branch=main"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-orjson \
    python3-mashumaro \
"

RDEPENDS:${PN}-ptest = "\
    ${PN} \
    python3-aioresponses \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-python-dotenv \
    python3-syrupy \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
