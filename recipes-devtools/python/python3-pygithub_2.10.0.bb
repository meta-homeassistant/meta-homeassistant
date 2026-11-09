SUMMARY = "Use the full Github API v3"
DESCRIPTION = "PyGitHub is a Python library to access the GitHub REST API. It \
    manages GitHub resources such as repositories, user profiles and \
    organizations from Python."
HOMEPAGE = "https://github.com/PyGithub/PyGithub"
LICENSE = "LGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "90ff24ef1cd1bd57124c2a3869cafee9d7b066909129ecdaba2c2d1903bc118d"

PYPI_PACKAGE = "pygithub"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += "\
    python3-cryptography \
    python3-pyjwt \
    python3-pynacl \
    python3-requests \
    python3-typing-extensions \
    python3-urllib3 \
"

RDEPENDS:${PN}-ptest += "\
    python3-responses \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
