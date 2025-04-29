SUMMARY = "Python Geocoding Toolbox"
HOMEPAGE = "https://github.com/geopy/geopy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b246754361f75980923b7feebfe71c15"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "50283d8e7ad07d89be5cb027338c6365a32044df3ae2556ad3f52f4840b3d0d1"

inherit pypi setuptools3 ptest-python-pytest

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

PYPI_PACKAGE = "geopy"

PTEST_PYTEST_DIR = "test"
