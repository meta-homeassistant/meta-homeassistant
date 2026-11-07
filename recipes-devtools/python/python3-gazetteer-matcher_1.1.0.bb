SUMMARY = "Constraint-driven gazetteer matcher for Home Assistant intents"
DESCRIPTION = "An English-language, constraint-driven intent recognizer for Home \
    Assistant voice commands. It complements Home Assistant's built-in \
    sentence grammars by handling home-specific names, fuzzy wording, \
    compound requests, and explicit conversation references while \
    rejecting interpretations that do not fit the upstream intent \
    schema."
HOMEPAGE = "https://pypi.org/project/gazetteer-matcher"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "844d11cb781302aded70f0a8eae8a2d1601e6e2aaa006745a667b500097635cc"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += "python3-wheel-native"

RDEPENDS:${PN} += "\
    python3-home-assistant-intents \
    python3-pyyaml \
    python3-unicode-rbnf \
"

RDEPENDS:${PN}-ptest += "\
    python3-pyyaml \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
    # test_support_catalog counts the intent combinations of the installed
    # home-assistant-intents, so it only holds for one intents release.
    sed -i 's|^addopts = "-q"$|addopts = "-q --deselect tests/test_matcher.py::test_support_catalog"|' ${D}${PTEST_PATH}/pyproject.toml
}
