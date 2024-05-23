COMPONENT_TEST_PACKAGES = "\
    ${PN}-assist-pipeline \
    ${PN}-axis \
    ${PN}-backup \
    ${PN}-bluetooth \
    ${PN}-cast \
    ${PN}-cloud \
    ${PN}-conversation \
    ${PN}-debugpy \
    ${PN}-dhcp \
    ${PN}-ffmpeg \
    ${PN}-file-upload \
    ${PN}-fritz \
    ${PN}-fritzbox \
    ${PN}-frontend \
    ${PN}-google-translate \
    ${PN}-hardware \
    ${PN}-hue \
    ${PN}-image-upload \
    ${PN}-ipp \
    ${PN}-matter \
    ${PN}-met \
    ${PN}-mobile-app \
    ${PN}-modbus \
    ${PN}-octoprint \
    ${PN}-radio-browser \
    ${PN}-recorder \
    ${PN}-scrape \
    ${PN}-sentry \
    ${PN}-shelly \
    ${PN}-ssdp \
    ${PN}-stream \
    ${PN}-systemmonitor \
    ${PN}-tts \
    ${PN}-upnp \
    ${PN}-usb \
    ${PN}-zeroconf \
"

python __anonymous() {
    if 'ptest' not in d.getVar('DISTRO_FEATURES'):
        return

    bb.build.addtask('do_addptest', 'do_compile', 'do_configure', d)
}

python do_addptest () {
    import os
    import shutil

    source_file = os.path.join(d.getVar('UNPACKDIR'), 'run-ptest-sample')
    target_file = os.path.join(d.getVar('UNPACKDIR'), 'run-ptest')
    shutil.copy(source_file, target_file)
    
    # Get the list of packages
    packages_list = d.getVar('COMPONENT_TEST_PACKAGES').split()
    
    # Iterate over each package and append the line to the file
    for package in packages_list:
        # Define the line to be appended
        line_to_append = "pytest --automake tests/components/" + package.removeprefix(d.getVar('PN')+'-').replace('-', '_') + "/"
        package_line = f"\n{line_to_append}\n"
        with open(target_file, 'a') as file:
            file.write(package_line)
}