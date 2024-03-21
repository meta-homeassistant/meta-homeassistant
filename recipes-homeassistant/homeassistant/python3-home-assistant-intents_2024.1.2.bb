DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/intents"
LICENSE = "Apache-2.0"
# TEMPORARY: this particular version has no tarball upstream so for this version only directly build from wheel.
# LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"
LIC_FILES_CHKSUM = "file://${WHL_BP}.dist-info/LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"
# inherit pypi python_setuptools_build_meta

# SRC_URI += "file://0001-Patch-pyproject.toml-to-use-upstream-version-of-setu.patch"
# SRC_URI[sha256sum] = "c83bd586bbc837356519f42a52859dc00eb4dec56b75f6e611fc656e9d77b3f2"

inherit python3-dir

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += "python3"

# We need to reimplement these since there is a - versus _ problem in the package name
WHL_BPN = "home_assistant_intents"
WHL_BP = "home_assistant_intents-${PV}"
WHL_PN = "home_assistant_intents"
SRC_URI = "https://files.pythonhosted.org/packages/77/ab/5e7d9de239e595221913bf7d3b6a395be6dbebbb1b5d65133aece617a74b/${WHL_BP}-py3-none-any.whl;downloadfilename=${BP}.zip;subdir=${BP}"
SRC_URI[sha256sum] = "10fdb16fe060e6a324098d5a8bab31477ea5e901a3052a297501d70242c931f3"

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BPN}
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BP}.dist-info

    # install -m 644 ${S}/${WHL_BPN}/* ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BPN}/
    cp -r ${S}/${WHL_BPN}/* ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BPN}/
    install -m 644 ${S}/${WHL_BP}.dist-info/* ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BP}.dist-info/
}

FILES:${PN} += "\
    ${libdir}/${PYTHON_DIR}/site-packages/${WHL_BPN} \
    ${libdir}/${PYTHON_DIR}/site-packages/${WHL_BP}.dist-info \
"

RDEPENDS:${PN} = "\
    python3-core (>=3.9.0) \
"

RDEPENDS:${PN}-dev += "\
    python3-hassil (>=1.5.1) \
    python3-pyyaml (>=6.0.1) \
    python3-voluptuous (=0.13.1) \
    python3-regex (>=2023.10.3) \
    python3-jinja2 (>=3.1.2) \
"
