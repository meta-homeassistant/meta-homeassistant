SUMMARY = "Tools for mapping, describing, and resetting USB devices."
HOMEPAGE = "https://github.com/bluetooth-devices/usb-devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/Bluetooth-Devices/usb-devices.git;protocol=https;branch=main"
SRCREV = "4d885fe1647108d71afa9e0aaff216b690226ea5"

inherit python_poetry_core ptest-python-pytest
