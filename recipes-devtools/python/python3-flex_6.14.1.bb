SUMMARY = "Swagger Schema validation."
HOMEPAGE = "https://github.com/pipermerriam/flex"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da75ff76699e2e1e5bc3c79b1de11927"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "292ed6a37f1ac0a10ad8669f5ceb82e8ba3106c16c54090820927bac8b0b29eb"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-six \
    python3-pyyaml \
    python3-validate-email \
    python3-rfc3987 \
    python3-requests \
    python3-strict-rfc3339 \
    python3-click \
    python3-jsonpointer \
"

PYPI_PACKAGE = "flex"
