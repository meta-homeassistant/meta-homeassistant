DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/hassil"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "8e43e8d36272e94ab20b962fc0cc3e0c3913f2b1b95dee0488d5440ff247cca7"

RDEPENDS:${PN} = "\
    python3-pyyaml (>=6.0) \
    python3-unicode-rbnf (=1.0.0) \
"
