SUMMARY = "Faster zlib and gzip compatible compression and decompression by providing python bindings for the isa-l library."
HOMEPAGE = "https://github.com/pycompression/python-isal"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=18130810ab035d8cac1d00602892f13d "

DEPENDS = "nasm-native python3-setuptools-scm-native"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI += "\
    file://0001-Ensure-build-paths-are-adjusted-for-a-yocto-environm.patch \
    file://0002-yocto-cross-build-and-cf-protection-fix.patch \
"
SRC_URI[sha256sum] = "124233e9a31a62030a07aafd48c26689561926f4e10417ed3ea46c211218f2b4"

RDEPENDS:${PN}-ptest += "\
    python3-tests \
"

# The bundled isa-l make.inc detects the CPU with uname, so a cross build
# for aarch64 on an x86-64 host compiles the x86 assembly and fails to link
# ("Relocations in generic ELF (EM: 62)"). Pass the target instead.
EXTRA_OEMAKE += "\
    YOCTO_BUILD=1 \
    host_cpu=${TARGET_ARCH} \
    arch=${TARGET_OS} \
"
