SUMMARY = "\
    Matter (formerly Project CHIP) creates more connections between more objects, \
    simplifying development for manufacturers and increasing compatibility for consumers, \
    guided by the Connectivity Standards Alliance."
HOMEPAGE = "https://github.com/project-chip/connectedhomeip"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WHL_BP}.dist-info/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

# TODO: currently the pypi version point actually to the link above in HOMEPAGE. However there is no
# direct clear link between what HA is using and what version is upstream. So for now we will directly use the wheel.

inherit python3-dir

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += "python3"

# We need to reimplement these since there is a - versus _ problem in the package name
WHL_BPN = "chip"
WHL_BP = "home_assistant_chip_clusters-${PV}"
WHL_PN = "home_assistant_chip_clusters"
SRC_URI = "https://files.pythonhosted.org/packages/bb/ee/1f80b7d35087b4da2343cc7e9f6af7796247a982f2d12a4598fa1c6029b1/${WHL_BP}-py3-none-any.whl;downloadfilename=${BP}.zip;subdir=${BP}"
SRC_URI[sha256sum] = "0e3ae72857b9b7434afefe742ed64c5df035ef3237d067b7aa7c4475dc2746f1"

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

RDEPENDS:${PN} += "\
    python3-aenum \
    python3-dacite \
"
