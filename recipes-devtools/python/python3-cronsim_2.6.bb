SUMMARY = "Cron expression parser and evaluator"
HOMEPAGE = "https://github.com/cuu508/cronsim"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c0217a74c57989decda9185589ba3ec7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5aab98716ef90ab5ac6be294b2c3965dbf76dc869f048846a0af74ebb506c10d"

inherit pypi setuptools3

PYPI_PACKAGE = "cronsim"
