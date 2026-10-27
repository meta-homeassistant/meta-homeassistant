FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI:append = " file://0001-c_check-ignore-gcc-configure-diagnostic.patch"

PACKAGECONFIG = "lapack cblas affinity dynarch"
