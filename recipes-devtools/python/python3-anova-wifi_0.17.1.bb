SUMMARY = "A package to get read only data from Anova precision cookers with wifi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6dff558e55968609815741eb8d5e5e6d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3db6d68214d8ad17268f4fc774b14490410a83671173c89d8e1e2705d23d5c5a"

inherit pypi python_poetry_core

PYPI_PACKAGE = "anova_wifi"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "python3-aiohttp (>=3.9.3)"
