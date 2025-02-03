SUMMARY = "Faster zlib and gzip compatible compression and decompression by providing python bindings for the isa-l library."
HOMEPAGE = "https://github.com/pycompression/python-isal"
LICENSE = "PSF-2.0"
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

SRC_URI:x86-64 = "\
    https://files.pythonhosted.org/packages/c3/de/f85284cd757028fc388edb694e13371b04372546cf21f6ee66fd16ddf7ce/${WHL_BP}-cp313-cp313-manylinux_2_17_x86_64.manylinux2014_x86_64.whl;downloadfilename=${BP}.zip;subdir=${BP};name=x86-64 \
"

SRC_URI:aarch64 = "\
    https://files.pythonhosted.org/packages/17/8c/fea8c856eb35c739cea3d886153e474ccbff07326a29565805189de9064e/${WHL_BP}-cp313-cp313-manylinux_2_17_aarch64.manylinux2014_aarch64.whl;downloadfilename=${BP}.zip;subdir=${BP};name=aarch64 \
"

SRC_URI[x86-64.sha256sum] = "c2474249bc5789656e6d7dd1fee1394aab5f46f7835c6ff6c0adc0f9320645ce"
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
