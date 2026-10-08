SUMMARY = "A full featured image capable of running Home Assistant and has all available components installed"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    python3-homeassistant \
"

require homeassistant-integrations.inc

IMAGE_LINGUAS = ""

IMAGE_FEATURES:append = "\
    ssh-server-openssh \
"

LICENSE = "MIT"

# 100 MiB of additional storage for config and runtime data
IMAGE_ROOTFS_EXTRA_SPACE = "102400"

inherit core-image

IMAGE_FSTYPES = "ext4.zst"

# Qemu Settings
###############################################################################
QB_MEM ?= "-m 4G"
QB_SMP = "-smp 12"
