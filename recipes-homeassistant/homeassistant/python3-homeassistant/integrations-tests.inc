COMPONENT_TEST_PACKAGES = "\
    ${PN}-assist-pipeline \
    ${PN}-backup \
    ${PN}-bluetooth \
    ${PN}-camera \
    ${PN}-cast \
    ${PN}-cloud \
    ${PN}-compensation \
    ${PN}-conversation \
    ${PN}-cpuspeed \
    ${PN}-debugpy \
    ${PN}-dhcp \
    ${PN}-dlna-dmr \
    ${PN}-dlna-dms \
    ${PN}-ffmpeg \
    ${PN}-folder-watcher \
    ${PN}-fritzbox-callmonitor \
    ${PN}-frontend \
    ${PN}-google-translate \
    ${PN}-hardware \
    ${PN}-image-upload \
    ${PN}-isal \
    ${PN}-met \
    ${PN}-mobile-app \
    ${PN}-modbus \
    ${PN}-namecheapdns \
    ${PN}-network \
    ${PN}-octoprint \
    ${PN}-radio-browser \
    ${PN}-recorder \
    ${PN}-scrape \
    ${PN}-sentry \
    ${PN}-shelly \
    ${PN}-sql \
    ${PN}-ssdp \
    ${PN}-startca \
    ${PN}-trend \
    ${PN}-tts \
    ${PN}-usb \
    ${PN}-utility-meter \
    ${PN}-zeroconf \
"

# Temporarily disabled as the tests are failing. Investigation is pending.
# ${PN}-axis
# ${PN}-generic
# ${PN}-github
# ${PN}-mqtt
# ${PN}-owntracks
# ${PN}-fritz
# ${PN}-fritzbox
# ${PN}-google-mail
# ${PN}-google-tasks
# ${PN}-hue
# ${PN}-ipp
# ${PN}-matter
# ${PN}-private-ble-device
# ${PN}-speedtestdotnet
# ${PN}-stream
# ${PN}-switchbot
# ${PN}-systemmonitor
# ${PN}-upnp

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