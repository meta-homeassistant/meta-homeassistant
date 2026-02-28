SUMMARY = "meta-homeassistant ptest test image"

require conf/include/ptest-packagelists-meta-homeassistant.inc

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    openssh \
    openssh-scp \
    nano \
    ptest-runner \
    python3-pip \
    ${MCNAME}-ptest \
"

PTESTS_META_HOMEASSISTANT = "${PTESTS_SLOW_META_HOMEASSISTANT} ${PTESTS_FAST_META_HOMEASSISTANT}"
BBCLASSEXTEND = "${@' '.join(['mcextend:'+x for x in d.getVar('PTESTS_META_HOMEASSISTANT').split()])}"

IMAGE_LINGUAS = ""

LICENSE = "MIT"

# 100 MiB of additional storage for config and runtime data
IMAGE_ROOTFS_EXTRA_SPACE = "102400"

inherit core-image

# Ensure the testimage machinery (runqemu) is given an image link
# name that contains "-image-" (hyphens on both sides) so runqemu's
# filename checks accept it. Include MACHINE to guarantee the
# trailing hyphen is present before the image suffix.
IMAGE_LINK_NAME = "${PN}-image-${MACHINE}"
