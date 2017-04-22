SUMMARY = "A small image just capable of runner Home Assistant"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL} python3-homeassistant"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image
