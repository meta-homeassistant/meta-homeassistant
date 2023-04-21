SUMMARY = "A Python library to access ISO country, subdivision, language, currency and script definitions and their translations."
HOMEPAGE = "https://github.com/flyingcircusio/pycountry"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8cf1799061bb2f68625332ab7039e11f"

SRC_URI[md5sum] = "47a8668fc5d86fcd2c608c19846e2912"
SRC_URI[sha256sum] = "b2163a246c585894d808f18783e19137cb70a0c18fb36748dc01fc6f109c1646"

inherit pypi python_setuptools_build_meta python_poetry_core
