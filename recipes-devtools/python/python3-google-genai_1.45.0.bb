SUMMARY = "GenAI Python SDK"
HOMEPAGE = "https://github.com/googleapis/python-genai"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "96ec32ae99a30b5a1b54cb874b577ec6e41b5d5b808bf0f10ed4620e867f9386"

DEPENDS += "\
	python3-id-native \
	python3-keyring-native \
	python3-markdown-it-py-native \
	python3-nh3-native \
	python3-pkginfo-native \
	python3-readme-renderer-native \
	python3-requests-native \
	python3-requests-toolbelt-native \
	python3-rfc3986-native \
	python3-rich-native \
	python3-twine-native \
"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = " \
	python3-anyio (>=4.8.0) \
	python3-google-auth (>=2.14.1) \
	python3-httpx (>=0.28.1) \
	python3-pydantic (>=2.0.0) \
	python3-requests (>=2.28.1) \
	python3-tenacity (>=8.2.3) \
	python3-websockets (>=13.0.0) \
	python3-typing-extensions (>=4.11.0) \
"

PYPI_PACKAGE = "google_genai"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
