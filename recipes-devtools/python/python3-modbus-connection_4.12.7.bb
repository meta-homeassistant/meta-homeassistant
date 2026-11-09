SUMMARY = "Backend-neutral Modbus connection abstraction"
DESCRIPTION = "A small, backend-neutral Modbus connection abstraction for Python \
    that works with pymodbus or tmodbus."
HOMEPAGE = "https://github.com/home-assistant-libs/modbus-connection"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "794556c938e7c34ae7edeb03cae46a5e777009163e7ca866625f091b398b805b"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN}-ptest += "\
    python3-pymodbus \
    python3-pytest-asyncio \
    python3-serialx \
    python3-terminal \
    python3-tmodbus \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
    # These SunSpec generator tests clone the SunSpec models with git.
    sed -i '/^\[tool\.pytest\.ini_options\]/a addopts = "--ignore=tests/test_sunspec_generate_1547.py --deselect tests/test_sunspec_generate.py::test_model_126_curves_follow_scanned_length --deselect tests/test_sunspec_generate.py::test_official_model_catalogue_generates_and_imports"' ${D}${PTEST_PATH}/pyproject.toml
}
