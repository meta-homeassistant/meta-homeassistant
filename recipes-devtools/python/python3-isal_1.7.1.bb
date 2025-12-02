SUMMARY = "Faster zlib and gzip compatible compression and decompression by providing python bindings for the isa-l library."
HOMEPAGE = "https://github.com/pycompression/python-isal"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "\
    file://${WHL_BP}.dist-info/LICENSE;md5=18130810ab035d8cac1d00602892f13d \
"

# TODO: currently trying to build this from sources is not working correctly. Somehow it tries to always use the HOST architecture
# and setup instead of using the correct sysroot.
# Therefore falling back to a direct wheel deployment.

inherit pypi_wheel

# We need to reimplement these since there is a - versus _ problem in the package name
WHL_BPN = "isal"
WHL_PKG_URI:x86-64 = "c3/de/f85284cd757028fc388edb694e13371b04372546cf21f6ee66fd16ddf7ce"
WHL_PKG_URI:aarch64 = "17/8c/fea8c856eb35c739cea3d886153e474ccbff07326a29565805189de9064e"
WHL_PYTHON_TAG = "cp313"
WHL_ABI_TAG = "cp313"
WHL_PLATFORM_TAG:x86-64 = "manylinux_2_17_x86_64.manylinux2014_x86_64"
WHL_PLATFORM_TAG:aarch64 = "manylinux_2_17_aarch64.manylinux2014_aarch64"

SRC_URI[x86_64.sha256sum] = "c2474249bc5789656e6d7dd1fee1394aab5f46f7835c6ff6c0adc0f9320645ce"
SRC_URI[aarch64.sha256sum] = "446d8392feae87423a589e21d7b9dc218ec2bf96cc36c05b53fc49036ac95e5b"

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
