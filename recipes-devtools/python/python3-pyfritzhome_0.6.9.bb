SUMMARY = "Python Library to access AVM Fritz!Box homeautomation"
HOMEPAGE = "https://github.com/hthiery/python-fritzhome"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01351c51c0264f1a06fee66797afb35a"

SRC_URI[sha256sum] = "99adab96b2e21765b01afc35bd37159ef50c8e2387a4436b31254891741047de"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-requests \
"
