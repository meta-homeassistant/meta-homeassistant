SUMMARY = "Fast implementation of asyncio event loop on top of libuv"
HOMEPAGE = "https://github.com/MagicStack/uvloop"
LICENSE = "Apache-2.0 & MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=bb92739ddad0a2811957bd98bdb90474 \
                    file://LICENSE-MIT;md5=489c8bc34154e4b59f5c58e664f7d70f \
                    file://vendor/libuv/LICENSE;md5=74b6f2f7818a4e3a80d03556f71b129b \
                    file://vendor/libuv/LICENSE-docs;md5=eacc0b19e3fb8dd12d2e110b24be0452 \
                    file://vendor/libuv/LICENSE-extra;md5=f9307417749e19bd1d6d68a394b49324"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Fix-compilation.patch"
SRC_URI[sha256sum] = "6c84bae345b9147082b17371e3dd5d42775bddce91f885499017f4607fdaf39f"

DEPENDS += "libuv"

inherit pypi python_setuptools_build_meta ptest-python-pytest cython

export USE_SYSTEM_LIBUV = "1"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.10.5) \
    python3-psutil \
    python3-pyopenssl (>=25.3.0) \
"

do_install_ptest:append() {
	install ${S}/mypy.ini ${D}${PTEST_PATH}/
	install ${S}/.flake8 ${D}${PTEST_PATH}/
}

PYPI_PACKAGE = "uvloop"
