# nooelint: oelint.var.mandatoryvar.SRC_URI oelint.var.mandatoryvar.HOMEPAGE oelint.file.underscores
# This recipe does not fetch any sources, it only triggers the execution of all meta-homeassistant ptest images.
# This recipe does not have a homepage, it only triggers the execution of all meta-homeassistant ptest images.
# This recipe has no version, it only triggers the execution of all meta-homeassistant ptest images.
SUMMARY = "Recipe to trigger execution of all meta-homeassistant ptest images."
LICENSE = "MIT"

inherit features_check nopackages
REQUIRED_DISTRO_FEATURES = "ptest"

require conf/include/ptest-packagelists-meta-homeassistant.inc

PTESTS_META_HOMEASSISTANT = "${PTESTS_SLOW_META_HOMEASSISTANT} ${PTESTS_FAST_META_HOMEASSISTANT}"

do_testimage[noexec] = "1"
do_testimage[depends] = "${@' '.join(['meta-homeassistant-image-ptest-'+x+':do_testimage' for x in d.getVar('PTESTS_META_HOMEASSISTANT').split()])}"

do_build[depends] = "${@' '.join(['meta-homeassistant-image-ptest-'+x+':do_build' for x in d.getVar('PTESTS_META_HOMEASSISTANT').split()])}"
