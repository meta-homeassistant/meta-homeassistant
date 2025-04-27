DESCRIPTION = "Issues related to the cloud integration in Nabu Casa"
HOMEPAGE = "https://github.com/NabuCasa/hass-nabucasa"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit python_setuptools_build_meta ptest-python-pytest

SRC_URI = "git://github.com/NabuCasa/hass-nabucasa.git;protocol=https;branch=master"
SRC_URI[sha256sum] = "faca4945f2abafbd5ca4a9350969e6655826ca2c88ac3a42088cc6f700ba0bb2"
SRCREV = "45a5446b0d30fddff905c6f06c2b669ae27f1c10"

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-acme (>=3.2.0) \
    python3-aiohttp (>=3.6.1) \
    ${@bb.utils.contains("DISTRO_FEATURES", "ptest", "python3-atomicwrites", "python3-atomicwrites-homeassistant (=1.4.1)",d)} \
    python3-attrs (>=19.3) \
    python3-ciso8601 (>=2.3.0) \
    python3-core (>=3.11) \
    python3-cryptography (>=42.0.0) \
    python3-ecdsa \
    python3-pycognito (=2024.5.1) \
    python3-pyjwt (>=2.8.0) \
    python3-snitun (>=0.40.0) \
    python3-webrtc-models (<1.0.0) \
    python3-pyasn1 \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-aiohttp \
    python3-pytest-timeout \
    python3-syrupy \
    python3-tomli \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
