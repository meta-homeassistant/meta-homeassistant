SUMMARY = "A modern Python data validation library"
DESCRIPTION = "Python data validation library, used by Home Assistant to validate \
    configuration and data."
HOMEPAGE = "https://github.com/frenck/probatio"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa33439907f7896804914a8c730a68f1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b5941dfdb68d813fbe49551d8802b241c4774f756fe51dfdedbad33e27797373"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN}-ptest += "\
    python3-hypothesis \
    python3-jsonschema \
    python3-openapi-schema-validator \
    python3-syrupy \
    python3-voluptuous \
    python3-voluptuous-openapi \
    python3-voluptuous-serialize \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
    # Coverage needs the covdefaults plugin and is not a test result. The
    # deselected tests compare against voluptuous 0.16 (OE has 0.15.2) or
    # read documentation the sdist does not ship. The hostile probe feeds a
    # 300 digit time zone key to zoneinfo.ZoneInfo, which raises OSError
    # (ENAMETOOLONG) instead of ZoneInfoNotFoundError when the tzdata package
    # is installed, as it is here; a CPython bug, not one in probatio
    # (https://github.com/python/cpython/issues/96463).
    sed -i 's|^addopts = "-q --cov |addopts = "-q --deselect tests/codecs/test_openapi.py::test_bare_callable_uses_first_param_hint_like_oracle --deselect tests/test_fuzz_engine.py::test_matches_voluptuous --deselect tests/test_messages.py::test_docs_reference_mirrors_the_catalog --deselect tests/test_v0_16.py::test_any_key_with_extra_policy_matches_voluptuous --deselect tests/test_v0_16.py::test_complex_required_deviation_is_a_single_error --deselect tests/validators/test_safe_contract.py::test_no_builtin_leaks_on_a_hostile_probe |' ${D}${PTEST_PATH}/pyproject.toml
}
