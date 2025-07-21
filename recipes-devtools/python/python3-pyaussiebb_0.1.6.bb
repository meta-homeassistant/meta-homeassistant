SUMMARY = "Aussie Broadband API module"
HOMEPAGE = "https://github.com/yaleman/pyaussiebb"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f84fdac7ad977505bc14b523db5af7f7"

SRC_URI[sha256sum] = "7771fe856d189f00a9e7de9614dffb74649cdf0b25d3422826b47eba07021bff"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += " \
        python3-pdm-native \
        python3-pdm-backend-native \
"

RDePENDS:${PN} = "\
	python3-requests \
	python3-aiohttp \
	python3-pydantic \
"

PYPI_PACKAGE = "pyaussiebb"
