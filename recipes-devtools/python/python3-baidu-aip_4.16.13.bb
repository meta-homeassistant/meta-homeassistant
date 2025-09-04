SUMMARY = "Baidu AIP SDK"
HOMEPAGE = "https://github.com/Baidu-AIP"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WHL_BP}.dist-info/LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

# TODO: currently the pypi version point actually to the link above in HOMEPAGE. However there is no
# direct clear link between what HA is using and what version is upstream. So for now we will directly use the wheel.

inherit python3-dir

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += "python3"

# We need to reimplement these since there is a - versus _ problem in the package name
WHL_BPN = "aip"
WHL_BP = "baidu_aip-${PV}"
WHL_PN = "baidu_aip"
SRC_URI = "https://files.pythonhosted.org/packages/53/18/823a605bcb66f1a6463d59e3230ba45ff292e3f932c999704d90632f73a2/${WHL_BP}-py3-none-any.whl;downloadfilename=${BP}.zip;subdir=${BP}"
SRC_URI[sha256sum] = "63a3cd37e293574e056c33d9a9a1e5f32fa0938c7d47ac5d24eea36e79e9e3f6"

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
