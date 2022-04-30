SUMMARY = "A small image just capable of running Home Assistant"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL} python3-homeassistant"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

# 100 MiB of additional storage for config and runtime data
IMAGE_ROOTFS_EXTRA_SPACE = "102400"

inherit core-image
