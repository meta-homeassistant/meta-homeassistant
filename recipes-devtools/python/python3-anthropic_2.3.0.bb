SUMMARY = "The official Python library for the anthropic API"
HOMEPAGE = "https://github.com/anthropics/anthropic-sdk-python"
# Relicensed from MIT to Apache-2.0 in 2.0.0; MIT still covers contributions
# merged before the change (LICENSE-MIT).
LICENSE = "Apache-2.0 AND MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5ea28c6cfd9ed9e632d125bfddb35ea6 \
                    file://LICENSE-MIT;md5=a1b0d196fbb9429c07b4b73611a766a4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-hatchling.patch"
SRC_URI[sha256sum] = "edfdea1e3fa7b3ce25df1511953408b2f03bfa61eb6f6268f766101a9e18ad53"

DEPENDS += "\
	python3-hatch-fancy-pypi-readme-native \
"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-anyio (>=4.1.0) \
    python3-docstring-parser (>=0.15) \
    python3-httpx2 (>=2.0.0) \
    python3-jiter (>=0.4.0) \
    python3-opentelemetry-api (>=1.1.0) \
    python3-pydantic (>=1.10.0) \
    python3-sniffio \
    python3-typing-extensions (>=4.14) \
"

RDEPENDS:${PN}-ptest += "\
	python3-botocore \
	python3-dirty-equals \
	python3-http-snapshot \
	python3-inline-snapshot \
	python3-pytest-xdist \
	python3-respx \
	python3-tests \
    python3-pytest-asyncio \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
	# The following items are added as tests need these files
    install ${S}/README.md ${D}${PTEST_PATH}/
}
