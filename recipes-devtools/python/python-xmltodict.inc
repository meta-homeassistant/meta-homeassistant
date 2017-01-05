DESCRIPTION = "Makes working with XML feel like you are working with JSON"
HOMEPAGE = "https://github.com/martinblech/xmltodict"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01441d50dc74476db58a41ac10cb9fa2"

inherit pypi

SRC_URI[md5sum] = "1275cbb2e66c354eb2b6a6bc946f3fa1"
SRC_URI[sha256sum] = "fc518ccf9adbbb917a2ddcb386be852ae6dd36935e1e8b9a3e760201abfdbf77"

BBCLASSEXTEND = "native nativesdk"
