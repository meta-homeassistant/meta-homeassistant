SUMMARY = "A lightweight and powerful JSONPath implementation for Python"
DESCRIPTION = "A lightweight and powerful JSONPath implementation for Python."
HOMEPAGE = "https://github.com/sean2077/jsonpath-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9b15fd455a4e7e03b2362ac7ab02d935"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "dded9932b4ec41fb8726e09c83afa4e6be618f938c2db287cc2a81723c639671"

inherit pypi python_hatchling ptest-python-pytest

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
    # pytest-benchmark does not work with pytest 9; skip the benchmarks.
    sed -i "/^\[tool\.pytest\.ini_options\]/a addopts = '-m \"not perf\"'" ${D}${PTEST_PATH}/pyproject.toml
}
