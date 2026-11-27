SUMMARY = "A command line utility to check for unused, missing and transitive dependencies in a Python project."
HOMEPAGE = "https://github.com/osprey-oss/deptry"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=566880d3db6b4f3e92b633e5bce4d654"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "45c8cd982c85cd4faae573ddff6920de7eec735336db6973f26a765ae7950f7d"
# nooelint: oelint.vars.srcurioptions - externalsrc requires type=git-dependency
SRC_URI += "git://github.com/astral-sh/ruff;protocol=https;nobranch=1;name=ruff;subdir=ruff;type=git-dependency"
SRCREV_ruff = "e4c7f357777a2fdd34dbe6a98b1b7d3e7488f675"

inherit pypi python_maturin ptest-python-pytest cargo-update-recipe-crates

require ${BPN}-crates.inc

# Redirect Cargo's locked Git source without modifying the external source tree.
# nooelint: oelint.task.heredocs - the local checkout path is build-specific
do_configure:append() {
    cat >> ${CARGO_HOME}/config.toml << EOF
[source.ruff-upstream]
git = "https://github.com/astral-sh/ruff"
tag = "0.15.6"
replace-with = "ruff-local"

[source.ruff-local]
git = "file://${UNPACKDIR}/ruff"
tag = "0.15.6"
EOF
}

RDEPENDS:${PN} = "\
    python3-click (>=8.0.0) \
    python3-packaging (>=23.2) \
    python3-requirements-parser (>=0.11.0) \
    python3-tomli (>=2.0.1) \
"

RDEPENDS:${PN}-ptest += "\
    python3-inline-snapshot \
    python3-pdm \
    python3-poetry-core \
    python3-pytest-cov \
    python3-pytest-xdist \
    python3-virtualenv \
"
