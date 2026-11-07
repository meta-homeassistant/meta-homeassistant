SUMMARY = "Python Geocoding Toolbox"
HOMEPAGE = "https://github.com/geopy/geopy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b246754361f75980923b7feebfe71c15"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7b6c849f18108dcce4faa3d614e2801107b465f7b05fd3c1db9db12e225ae950"

inherit pypi python_setuptools_build_meta ptest-python-pytest

# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "aiohttp dev dev-docs dev-lint dev-test requests timezone"
PACKAGECONFIG[aiohttp] = ",,,python3-aiohttp"
PACKAGECONFIG[dev] = ",,,python3-coverage python3-flake8 python3-isort python3-pytest python3-pytest-asyncio python3-readme_renderer python3-sphinx python3-sphinx-issues python3-sphinx_rtd_theme"
PACKAGECONFIG[dev-docs] = ",,,python3-readme_renderer python3-sphinx python3-sphinx-issues python3-sphinx_rtd_theme"
PACKAGECONFIG[dev-lint] = ",,,python3-flake8 python3-isort"
PACKAGECONFIG[dev-test] = ",,,python3-coverage python3-pytest python3-pytest-asyncio python3-sphinx"
PACKAGECONFIG[requests] = ",,,python3-requests python3-urllib3"
PACKAGECONFIG[timezone] = ",,,python3-pytz"

RDEPENDS:${PN} += "\
    python3-requests (>=2.16.2) \
    python3-urllib3 (>=1.24.2) \
    python3-geographiclib \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"


PTEST_PYTEST_DIR = "test"
