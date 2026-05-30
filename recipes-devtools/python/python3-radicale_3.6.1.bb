SUMMARY = "CalDAV and CardDAV Server"
HOMEPAGE = "https://radicale.org/"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=97a733ff40c50b4bfc74471e1f6ca88b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5b5529c093fc3a6e9eba6a3280d930ea6573b485a1bd8d25b7daa6ee70f5224b"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-defusedxml \
    python3-packaging \
    python3-requests \
    python3-vobject (>=0.9.6) \
    python3-pika (>=1.1.0) \
    python3-libpass (>=1.9.3) \
"
