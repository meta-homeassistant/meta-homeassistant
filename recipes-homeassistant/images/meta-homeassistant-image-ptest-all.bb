DESCRIPTION = "Recipe to trigger execution of all meta-homeassistant ptest images."
LICENSE = "MIT"

inherit features_check nopackages
REQUIRED_DISTRO_FEATURES = "ptest"

require conf/include/ptest-packagelists-meta-homeassistant.inc

PTESTS_META_HOMEASSISTANT = "${PTESTS_SLOW_META_HOMEASSISTANT} ${PTESTS_FAST_META_HOMEASSISTANT}"

do_testimage[noexec] = "1"
do_testimage[depends] = "${@' '.join(['meta-homeassistant-ptest-'+x+':do_testimage' for x in d.getVar('PTESTS_META_HOMEASSISTANT').split()])}"

do_build[depends] = "${@' '.join(['meta-homeassistant-ptest-'+x+':do_build' for x in d.getVar('PTESTS_META_HOMEASSISTANT').split()])}"
