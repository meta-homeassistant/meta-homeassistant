SUMMARY = "Easily test your HTTP library against a local copy of httpbin"
HOMEPAGE = "https://github.com/kevin1024/pytest-httpbin"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=53dec604b1f680b79fb0b3c71052b104"

SRC_URI[sha256sum] = "d40579838443228327f9fe4f08d9338bee8885c29fe933e5f2d58c20a26c33c6"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-httpbin \
"

RDEPENDS:${PN}-ptest = "\
    python3-requests \
    python3-httpbin \
    ${PN} \
"

PYPI_PACKAGE = "pytest_httpbin"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
