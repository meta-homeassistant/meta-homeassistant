DESCRIPTION = "Example image demonstrating how to build SWUpdate compound image"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit swupdate

SRC_URI = "\
    file://sw-description \
"

HAIMAGE="core-image-homeassistant"

# images to build before building swupdate image
IMAGE_DEPENDS = "${HAIMAGE}"

# images and files that will be included in the .swu image
SWUPDATE_IMAGES = "${HAIMAGE}"

SWUPDATE_IMAGES_FSTYPES[core-image-homeassistant] = ".ext4.gz"
