inherit python3-dir

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += "python3"

def pypi_package(d):
    bpn = d.getVar('BPN')
    if bpn.startswith('python-'):
        return bpn[7:]
    elif bpn.startswith('python3-'):
        return bpn[8:]
    return bpn

WHL_BPN ?= "${@pypi_package(d)}"
WHL_BP ?= "${@pypi_package(d)}-${PV}"
WHL_PKG_URI ?= "-"
WHL_PYTHON_TAG ?= "py3"
WHL_ABI_TAG ?= "none"
WHL_PLATFORM_TAG ?= "any"
SRC_URI = "https://files.pythonhosted.org/packages/${WHL_PKG_URI}/${WHL_BP}-${WHL_PYTHON_TAG}-${WHL_ABI_TAG}-${WHL_PLATFORM_TAG}.whl;downloadfilename=${BP}.zip;subdir=${BP};name=${SDK_ARCH}"

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BPN}
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BP}.dist-info

    cp -r ${S}/${WHL_BPN}/* ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BPN}/
    install -m 644 ${S}/${WHL_BP}.dist-info/* ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BP}.dist-info/
}

FILES:${PN} += "\
    ${libdir}/${PYTHON_DIR}/site-packages/${WHL_BPN} \
    ${libdir}/${PYTHON_DIR}/site-packages/${WHL_BP}.dist-info \
"
