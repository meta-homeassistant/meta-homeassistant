SUMMARY = "Cron expression parser and evaluator"
HOMEPAGE = "https://github.com/cuu508/cronsim"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c0217a74c57989decda9185589ba3ec7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/cuu508/cronsim.git;branch=main;protocol=https"
SRCREV = "fd2e617787e94b15beee27fee6ebe6cbe79a72a2"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN}-ptest += "\
    python3-zoneinfo \
    python3-tzdata \
"
