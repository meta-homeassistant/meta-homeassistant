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
WHL_BP = "isal-${PV}"
WHL_PN = "isal"

SRC_URI:x86-64 = "\
    https://files.pythonhosted.org/packages/b1/94/36622a5b97ed9b0648e8853bcaade872abc040050c3ca5d775608baf85a5/${WHL_BP}-cp312-cp312-manylinux_2_17_x86_64.manylinux2014_x86_64.whl;downloadfilename=${BP}.zip;subdir=${BP};name=x86-64 \
"

SRC_URI:aarch64 = "\
    https://files.pythonhosted.org/packages/ec/25/cf5a18c06a668ee63c33d21e3a902592c6a4418b383938f0973b93761c31/${WHL_BP}-cp312-cp312-manylinux_2_17_aarch64.manylinux2014_aarch64.whl;downloadfilename=${BP}.zip;subdir=${BP};name=aarch64 \
"

SRC_URI[x86-64.sha256sum] = "db80adfae5cfe2311274cade0d2b9f4ad250bf0aeb1fcc405ebfcf2cd228b15e"
SRC_URI[aarch64.sha256sum] = "d3540855990513846b0dc8914ef85711b88f9911549b2d0a70fd16c659f4aa4e"

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
