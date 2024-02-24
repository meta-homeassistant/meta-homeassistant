SUMMARY = "Frontend for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/home-assistant-polymer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

# Pypi only offers the wheel version and no tar-gz for this package. Point to
# the github release tarball insteadd
PYPI_SRC_URI = "https://github.com/home-assistant/frontend/releases/download/${PV}/home-assistant-frontend-${PV}.tar.gz"

inherit pypi python_setuptools_build_meta

SRC_URI += "file://0001-Allowed-for-newer-wheel-version.patch"
SRC_URI[sha256sum] = "fc0fa13f8d76ab17f1dbe6818cdfee0a69e536468fdc9f10df59705f20466f79"

RDEPENDS:${PN} += " \
    python3-core (>=3.10) \
"
