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
    https://files.pythonhosted.org/packages/7f/46/0c0a1dafc2c5ee4f1bb6f87a09841bf37e4148dbda4f088ac6a3fc0e57c8/${WHL_BP}-cp312-cp312-manylinux_2_17_x86_64.manylinux2014_x86_64.whl;downloadfilename=${BP}.zip;subdir=${BP};name=x86-64 \
"

SRC_URI:aarch64 = "\
    https://files.pythonhosted.org/packages/ee/6f/2064c978ea6912dbc10e5ceb2ae535563222f8758ee5b8d74a70ecad4424/${WHL_BP}-cp312-cp312-manylinux_2_17_aarch64.manylinux2014_aarch64.whl;downloadfilename=${BP}.zip;subdir=${BP};name=aarch64 \
"
SRC_URI[x86-64.sha256sum] = "f2d931e35e70a2d0e32124b4a2d5aeb5b1016b497c95a75a36ddfeaa68d06645"
SRC_URI[aarch64.sha256sum] = "24dda4a2c3eae0e1aaf16283b71f6b4ad75d7784d9e7d9545330bfcd274699bc"

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
