# Based on https://stackoverflow.com/questions/48660051/yocto-recipe-python-whl-package/73474261

inherit python3-dir 

WHL_BPN="${@ d.getVar('BPN').replace(d.getVar('PYTHON_PN')+'-', '', 1)}"
WHL_BP="${@ d.getVar('BP').replace(d.getVar('PYTHON_PN')+'-', '', 1)}"
WHL_PN="${@ d.getVar('PN').replace(d.getVar('PYTHON_PN')+'-', '', 1)}"

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += "python3"

FILES:${PN} += "\
    ${libdir}/${PYTHON_DIR}/site-packages/${WHL_BPN} \
    ${libdir}/${PYTHON_DIR}/site-packages/${WHL_BP}.dist-info \
"

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BPN}
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BP}.dist-info

    # install -m 644 ${S}/${WHL_BPN}/* ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BPN}/
    cp -r ${S}/${WHL_BPN}/* ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BPN}/
    install -m 644 ${S}/${WHL_BP}.dist-info/* ${D}${libdir}/${PYTHON_DIR}/site-packages/${WHL_BP}.dist-info/
}