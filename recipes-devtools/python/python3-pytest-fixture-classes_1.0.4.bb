SUMMARY = "Fixtures as classes that work well with dependency injection, autocompletetion, type checkers, and language servers"
HOMEPAGE = "https://github.com/zmievsa/pytest-fixture-classes"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=109ba68c88a940bcd0b937b9dffd9294"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b1f7979abea4d409bd58d0d70762805306789114f2137f36897a8bbb2ae6e28a"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "python3-typing-extensions"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-cov \
"
