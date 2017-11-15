SUMMARY = "A small image just capable of running Home Assistant"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL} python3-homeassistant python3-appdaemon"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image
