SUMMARY = "Discover and control ANEL NET-PwrCtrl devices."
HOMEPAGE = "https://github.com/mweinelt/anel-pwrctrl/archive/ed26e8830e28a2bfa4260a9002db23ce3e7e63d7.zip#anel_pwrctrl==0.0.1"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "01cb27603f4278601aae6e5077079417a094170532c217e6538e8d1bcf829b8b"

inherit pypi setuptools3

PYPI_PACKAGE_SDIST = "anel_pwrctrl-homeassistant"
