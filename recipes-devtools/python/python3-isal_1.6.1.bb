SUMMARY = "Faster zlib and gzip compatible compression and decompression by providing python bindings for the isa-l library."
HOMEPAGE = "https://github.com/pycompression/python-isal"
LICENSE = "PSF-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "\
    file://${WHL_BP}.dist-info/LICENSE;md5=18130810ab035d8cac1d00602892f13d \
"

# TODO: currently trying to build this from sources is not working correctly. Somehow it tries to always use the HOST architecture
# and setup instead of using the correct sysroot.
# Therefore falling back to a direct wheel deployment.

inherit python3-dir

do_unpack[depends] += "unzip-native:do_populate_sysroot"

DEPENDS += "python3"

# We need to reimplement these since there is a - versus _ problem in the package name
WHL_BPN = "isal"
WHL_BP:aarch64 = "isal-${PV}"
WHL_PN = "isal"

SRC_URI:aarch64 = "\
    https://files.pythonhosted.org/packages/ec/25/cf5a18c06a668ee63c33d21e3a902592c6a4418b383938f0973b93761c31/${WHL_BP}-cp312-cp312-manylinux_2_17_aarch64.manylinux2014_aarch64.whl;downloadfilename=${BP}.zip;subdir=${BP} \
"

SRC_URI[sha256sum] = "d3540855990513846b0dc8914ef85711b88f9911549b2d0a70fd16c659f4aa4e"

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
