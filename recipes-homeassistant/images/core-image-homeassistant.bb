SUMMARY = "A small image just capable of running Home Assistant"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL} python3-homeassistant python3-appdaemon"

IMAGE_INSTALL += "\ 
	libubootenv \
	mosquitto \
	swupdate \
	swupdate-progress \
	swupdate-www \
	swupdate-tools \
	"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

# 100 MiB of additional storage for config and runtime data
IMAGE_ROOTFS_EXTRA_SPACE = "102400"

inherit core-image
