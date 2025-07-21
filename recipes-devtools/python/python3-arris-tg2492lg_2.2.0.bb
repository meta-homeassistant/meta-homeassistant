SUMMARY = "Python client for the Arris TG2492LG"
HOMEPAGE = "https://github.com/vanbalken/arris-tg2492lg"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db62027dcbc0a065e4305804637848c7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9a05b64efb355739d4bd4d6bac18f6c9cf75ab0122c3a76602444e9bed003a0f"

DEPENDS:append = " \
    python3-aiohttp-native \
"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.11.18) \
"

PYPI_PACKAGE = "arris-tg2492lg"
