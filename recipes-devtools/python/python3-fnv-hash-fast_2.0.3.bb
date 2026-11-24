SUMMARY = "A fast version of fnv1a"
HOMEPAGE = "https://github.com/bdraco/fnv-hash-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_poetry_core cython


SRC_URI[sha256sum] = "57b499a80ea8f7daf901aff047377264ef21577b40575183807dba37bcc00d6f"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-fnvhash (>=0.1.0) \
"