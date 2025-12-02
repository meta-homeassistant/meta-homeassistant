SUMMARY = "\
    Matter (formerly Project CHIP) creates more connections between more objects, \
    simplifying development for manufacturers and increasing compatibility for consumers, \
    guided by the Connectivity Standards Alliance."
HOMEPAGE = "https://github.com/project-chip/connectedhomeip"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WHL_BP}.dist-info/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

inherit pypi_wheel

# We need to reimplement these since there is a - versus _ problem in the package name
WHL_BPN = "chip"
WHL_BP = "home_assistant_chip_clusters-${PV}"
WHL_PKG_URI = "bb/ee/1f80b7d35087b4da2343cc7e9f6af7796247a982f2d12a4598fa1c6029b1"

SRC_URI[x86_64.sha256sum] = "0e3ae72857b9b7434afefe742ed64c5df035ef3237d067b7aa7c4475dc2746f1"
SRC_URI[aarch64.sha256sum] = "0e3ae72857b9b7434afefe742ed64c5df035ef3237d067b7aa7c4475dc2746f1"

RDEPENDS:${PN} += "\
    python3-aenum \
    python3-dacite \
"
