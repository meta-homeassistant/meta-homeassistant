COMPONENT_TEST_PACKAGES = "\
    ${PN}-accuweather \
    ${PN}-acmeda \
    ${PN}-adax \
    ${PN}-adguard \
    ${PN}-advantage-air \
    ${PN}-air-quality \
    ${PN}-airthings-ble \
    ${PN}-aladdin-connect \
    ${PN}-alarm-control-panel \
    ${PN}-alert \
    ${PN}-alexa \
    ${PN}-analytics \
    ${PN}-api \
    ${PN}-application-credentials \
    ${PN}-assist-pipeline \
    ${PN}-assist-satellite \
    ${PN}-auth \
    ${PN}-automation \
    ${PN}-backup \
    ${PN}-bayesian \
    ${PN}-binary-sensor \
    ${PN}-blueprint \
    ${PN}-bluesound \
    ${PN}-bluetooth \
    ${PN}-bluetooth-adapters \
    ${PN}-bluetooth-le-tracker \
    ${PN}-button \
    ${PN}-calendar \
    ${PN}-camera \
    ${PN}-cast \
    ${PN}-cert-expiry \
    ${PN}-clicksend-tts \
    ${PN}-climate \
    ${PN}-cloud \
    ${PN}-compensation \
    ${PN}-config \
    ${PN}-configurator \
    ${PN}-counter \
    ${PN}-cover \
    ${PN}-cpuspeed \
    ${PN}-date \
    ${PN}-datetime \
    ${PN}-debugpy \
    ${PN}-demo \
    ${PN}-derivative \
    ${PN}-device-automation \
    ${PN}-device-sun-light-trigger \
    ${PN}-device-tracker \
    ${PN}-dhcp \
    ${PN}-diagnostics \
    ${PN}-dialogflow \
    ${PN}-dlna-dmr \
    ${PN}-dlna-dms \
    ${PN}-downloader \
    ${PN}-dte-energy-bridge \
    ${PN}-duckdns \
    ${PN}-dunehd \
    ${PN}-eight-sleep \
    ${PN}-emulated-hue \
    ${PN}-energy \
    ${PN}-event \
    ${PN}-evohome \
    ${PN}-facebook \
    ${PN}-fail2ban \
    ${PN}-fan \
    ${PN}-ffmpeg \
    ${PN}-file-upload \
    ${PN}-filesize \
    ${PN}-filter \
    ${PN}-flux \
    ${PN}-folder \
    ${PN}-folder-watcher \
    ${PN}-freedns \
    ${PN}-fritzbox \
    ${PN}-fritzbox-callmonitor \
    ${PN}-frontend \
    ${PN}-generic-hygrostat \
    ${PN}-generic-thermostat \
    ${PN}-geo-location \
    ${PN}-geofency \
    ${PN}-google-assistant \
    ${PN}-google-translate \
    ${PN}-google-wifi \
    ${PN}-gpslogger \
    ${PN}-graphite \
    ${PN}-group \
    ${PN}-hardkernel \
    ${PN}-hardware \
    ${PN}-hddtemp \
    ${PN}-history \
    ${PN}-history-stats \
    ${PN}-homeassistant \
    ${PN}-homeassistant-alerts \
    ${PN}-homeassistant-green \
    ${PN}-http \
    ${PN}-hue \
    ${PN}-humidifier \
    ${PN}-image \
    ${PN}-image-processing \
    ${PN}-image-upload \
    ${PN}-input-boolean \
    ${PN}-input-button \
    ${PN}-input-datetime \
    ${PN}-input-number \
    ${PN}-input-select \
    ${PN}-input-text \
    ${PN}-integration \
    ${PN}-intent \
    ${PN}-intent-script \
    ${PN}-ios \
    ${PN}-ipp \
    ${PN}-isal \
    ${PN}-kitchen-sink \
    ${PN}-lawn-mower \
    ${PN}-life360 \
    ${PN}-light \
    ${PN}-local-file \
    ${PN}-local-ip \
    ${PN}-locative \
    ${PN}-lock \
    ${PN}-logbook \
    ${PN}-logentries \
    ${PN}-logger \
    ${PN}-london-air \
    ${PN}-lovelace \
    ${PN}-manual \
    ${PN}-mazda \
    ${PN}-media-player \
    ${PN}-media-source \
    ${PN}-meraki \
    ${PN}-met \
    ${PN}-microsoft-face \
    ${PN}-microsoft-face-detect \
    ${PN}-microsoft-face-identify \
    ${PN}-min-max \
    ${PN}-mjpeg \
    ${PN}-mobile-app \
    ${PN}-mold-indicator \
    ${PN}-moon \
    ${PN}-my \
    ${PN}-myq \
    ${PN}-namecheapdns \
    ${PN}-network \
    ${PN}-nmap-tracker \
    ${PN}-no-ip \
    ${PN}-notify \
    ${PN}-number \
    ${PN}-octoprint \
    ${PN}-openalpr-cloud \
    ${PN}-openhardwaremonitor \
    ${PN}-otp \
    ${PN}-panel-custom \
    ${PN}-persistent-notification \
    ${PN}-person \
    ${PN}-plant \
    ${PN}-proximity \
    ${PN}-push \
    ${PN}-qwikswitch \
    ${PN}-radio-browser \
    ${PN}-random \
    ${PN}-recorder \
    ${PN}-recovery-mode \
    ${PN}-remote \
    ${PN}-repairs \
    ${PN}-rest-command \
    ${PN}-rhasspy \
    ${PN}-rss-feed-template \
    ${PN}-scene \
    ${PN}-schedule \
    ${PN}-scrape \
    ${PN}-script \
    ${PN}-search \
    ${PN}-select \
    ${PN}-sentry \
    ${PN}-shelly \
    ${PN}-shopping-list \
    ${PN}-sigfox \
    ${PN}-simulated \
    ${PN}-siren \
    ${PN}-smtp \
    ${PN}-spaceapi \
    ${PN}-speedtestdotnet \
    ${PN}-ssdp \
    ${PN}-startca \
    ${PN}-statistics \
    ${PN}-stt \
    ${PN}-sun \
    ${PN}-switch \
    ${PN}-switch-as-x \
    ${PN}-system-health \
    ${PN}-system-log \
    ${PN}-systemmonitor \
    ${PN}-tag \
    ${PN}-tcp \
    ${PN}-template \
    ${PN}-text \
    ${PN}-threshold \
    ${PN}-time \
    ${PN}-time-date \
    ${PN}-timer \
    ${PN}-tod \
    ${PN}-todo \
    ${PN}-tomato \
    ${PN}-trace \
    ${PN}-trafikverket-camera \
    ${PN}-trafikverket-ferry \
    ${PN}-trafikverket-train \
    ${PN}-trafikverket-weatherstation \
    ${PN}-trend \
    ${PN}-tts \
    ${PN}-uk-transport \
    ${PN}-universal \
    ${PN}-update \
    ${PN}-upnp \
    ${PN}-uptime \
    ${PN}-usb \
    ${PN}-utility-meter \
    ${PN}-vacuum \
    ${PN}-valve \
    ${PN}-voicerss \
    ${PN}-wake-word \
    ${PN}-water-heater \
    ${PN}-weather \
    ${PN}-webhook \
    ${PN}-worldclock \
    ${PN}-wsdot \
    ${PN}-xiaomi \
    ${PN}-yandextts \
    ${PN}-zeroconf \
    ${PN}-zodiac \
    ${PN}-zone \
    ${PN}-zwave-me \
"

# Temporarily disabled as the tests are failing. Investigation is pending.
# ${PN}-axis
# ${PN}-conversation
# ${PN}-default-config
# ${PN}-dsmr-reader
# ${PN}-fritz
# ${PN}-generic
# ${PN}-github
# ${PN}-google-mail
# ${PN}-google-sheets
# ${PN}-google-tasks
# ${PN}-homeassistant-hardware
# ${PN}-homeassistant-sky-connect
# ${PN}-homeassistant-yellow
# ${PN}-manual-mqtt
# ${PN}-matter
# ${PN}-modbus
# ${PN}-mqtt
# ${PN}-mqtt-eventstream
# ${PN}-mqtt-json
# ${PN}-mqtt-room
# ${PN}-mqtt-statestream
# ${PN}-onboarding
# ${PN}-owntracks
# ${PN}-private-ble-device
# ${PN}-raspberry-pi
# ${PN}-sensor
# ${PN}-shell-command
# ${PN}-snips
# ${PN}-sql
# ${PN}-stream
# ${PN}-switchbot
# ${PN}-telegram
# ${PN}-temper
# ${PN}-websocket-api
# ${PN}-zwave-js

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

    with open(target_file, 'a') as file:
            file.write(f"\npytest --automake \\\n")
    
    # Iterate over each package and append the line to the file
    for package in packages_list:
        # Define the line to be appended
        line_to_append = "tests/components/" + package.removeprefix(d.getVar('PN')+'-').replace('-', '_') + "/"
        package_line = f"  {line_to_append} \\\n"
        with open(target_file, 'a') as file:
            file.write(package_line)
    with open(target_file, 'a') as file:
        line_to_append = ""
        package_line = f"  {line_to_append} \\\n"
        file.write(package_line)
}