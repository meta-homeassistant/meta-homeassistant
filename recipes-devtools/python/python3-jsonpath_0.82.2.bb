SUMMARY = "An XPath for JSON"
HOMEPAGE = "http://www.ultimate.com/phil/python/#jsonpath"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;beginline=44;endline=44;md5=3e88fc37e613e73e47ca2b0e99caccfe"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d87ef2bcbcded68ee96bc34c1809b69457ecec9b0c4dd471658a12bd391002d1"

inherit pypi setuptools3

PYPI_PACKAGE = "jsonpath"
