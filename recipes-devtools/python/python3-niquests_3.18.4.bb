SUMMARY = "Niquests is a simple, yet elegant, HTTP library. It is a drop-in replacement for Requests, which is under feature freeze."
HOMEPAGE = "https://github.com/jawah/niquests"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d2f672163c58ce9bc1922ac71c88c0f6b999878b7c642fe3ba8ded275dcbe2ec"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "niquests"

RDEPENDS:${PN} += "\
	python3-charset-normalizer \
	python3-urllib3 \
	python3-wassima \
"
	

RDEPENDS:${PN}-ptest += "\
	python3-coverage \
	python3-pytest-httpbin \
	python3-pytest-asyncio \
	python3-httpbin \
	python3-cryptography \
	python3-werkzeug \
	python3-fastapi \
	python3-aiofiles \
"
