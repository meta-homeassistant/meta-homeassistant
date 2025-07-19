PACKAGECONFIG ??= ""
PACKAGECONFIG[integration-tests] = ",,,"

COMPONENT_TEST_PACKAGES = ""
COMPONENT_TEST_PACKAGES:append = "\
    ${@bb.utils.contains('PACKAGECONFIG', 'integration-tests', '\
    ${PN}-acaia \
    ${PN}-accuweather \
    ${PN}-acmeda \
    ${PN}-application-credentials \
    ${PN}-alarm-control-panel \
    ${PN}-aladdin-connect \
    ${PN}-ai-task \
    ${PN}-air-quality \
    ${PN}-alert \
    ${PN}-alexa \
    ${PN}-altruist \
    ${PN}-analytics \
    ${PN}-apple-tv \
    ${PN}-aprilaire \
    ${PN}-aprs \
    ${PN}-apsystems \
    ${PN}-aranet \
    ${PN}-dunehd \
    ${PN}-manual \
    ${PN}-mcp \
    ${PN}-smartthings \
    ${PN}-steam-online \
', '', d)}"

# The following component is specific to this MACHINE_ARCH so treat it as such
COMPONENT_TEST_PACKAGES:append:raspberrypi4 = "\
    ${PN}-raspberry-pi \
"

python __anonymous() {
    if 'ptest' not in d.getVar('DISTRO_FEATURES'):
        return
    bb.build.addtask('do_addptest', 'do_compile', 'do_configure', d)
}

python do_addptest () {
    import shutil

    source_file = os.path.join(d.getVar('UNPACKDIR'), 'run-ptest-sample')
    target_file = os.path.join(d.getVar('UNPACKDIR'), 'run-ptest')
    shutil.copy(source_file, target_file)

    if bb.utils.contains('PACKAGECONFIG', 'integration-tests', True, False, d):
        # Get the list of packages
        packages_list = d.getVar('COMPONENT_TEST_PACKAGES').split()

        with open(target_file, 'a', encoding='utf-8') as file:
            file.write("\npytest -n auto --automake \\\n")

        # Iterate over each package and append the line to the file
        for package in packages_list:
            # Define the line to be appended
            line_to_append = "tests/components/" + package.removeprefix(d.getVar('PN')+'-').replace('-', '_') + "/"
            package_line = f"  {line_to_append} \\\n"
            with open(target_file, 'a', encoding='utf-8') as file:
                file.write(package_line)
        with open(target_file, 'a', encoding='utf-8') as file:
            line_to_append = ""
            package_line = f"  {line_to_append} \\\n"
            file.write(package_line)
}