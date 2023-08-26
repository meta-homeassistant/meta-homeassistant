SUMMARY = "Python interface to the Google WebRTC Voice Activity Detector (VAD)"
HOMEPAGE = "https://github.com/wiseman/py-webrtcvad"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=425b45e5a79ac786f2f8e977a3beaad4"

SRC_URI[sha256sum] = "f1bed2fb25b63fb7b1a55d64090c993c9c9167b28485ae0bcdd81cf6ede96aea"

inherit pypi setuptools3

PACKAGECONFIG[dev] = "\
    python3-check-manifest \
    python3-memory_profiler \
    python3-nose \
    python3-psutil \
    python3-unittest2 \
    python3-zest-releaser \
"
