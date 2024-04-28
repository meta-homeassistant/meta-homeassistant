DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/intents"
LICENSE = "CC-BY-4.0"
# TEMPORARY: this particular version has no tarball upstream so for this version only directly build from wheel.
# LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"
LIC_FILES_CHKSUM = "file://${WHL_BP}.dist-info/LICENSE.md;md5=2ab724713fdaf49e4523c4503bfd068d"
inherit python3-dir

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += "python3"

# We need to reimplement these since there is a - versus _ problem in the package name
WHL_BPN = "home_assistant_intents"
WHL_BP = "home_assistant_intents-${PV}"
WHL_PN = "home_assistant_intents"
SRC_URI = "https://files.pythonhosted.org/packages/af/e4/b2dad9fc0f37c4ce4556b91dd4665fee386d3ed0bfa41c3b62b4b40e115b/${WHL_BP}-py3-none-any.whl;downloadfilename=${BP}.zip;subdir=${BP}"
SRC_URI[sha256sum] = "1ab69856d8a8288a0a94f44186187395b05f23a85e5c0680d4c42952a0201034"

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
    python3-hassil (>=1.7.0) \
    python3-pyyaml (>=6.0.1) \
    python3-voluptuous (=0.13.1) \
    python3-regex (>=2023.12.25) \
    python3-jinja2 (>=3.1.3) \
"