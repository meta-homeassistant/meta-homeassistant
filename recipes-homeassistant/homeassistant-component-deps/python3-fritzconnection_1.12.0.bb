SUMMARY = "Python-Tool to communicate with the AVM Fritz!Box by the TR-064 protocol and the AHA-HTTP-Interface"
HOMEPAGE = "https://github.com/kbr/fritzconnection"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=14e77f0736b95df3d3544d00d4894342"

SRC_URI[sha256sum] = "1b91ed4e971b4683557fc420f2ab6bff16660fad2848e63f2742c253d28618f0"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-requests (>=2.22.0) \
"
