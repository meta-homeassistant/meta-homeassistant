PACKAGECONFIG ??= ""
PACKAGECONFIG[integration-tests] = ",,,"

COMPONENT_TEST_PACKAGES_FLAKY = ""
COMPONENT_TEST_PACKAGES_FLAKY:append = "\
    ${@bb.utils.contains('PACKAGECONFIG', 'integration-tests', '\
    ${PN}-airtouch5 \
    ${PN}-assist-pipeline \
    ${PN}-backup \
    ${PN}-bang-olufsen \
    ${PN}-dhcp \
    ${PN}-dsmr \
    ${PN}-elevenlabs \
', '', d)}"

COMPONENT_TEST_PACKAGES = ""
COMPONENT_TEST_PACKAGES:append = "\
    ${@bb.utils.contains('PACKAGECONFIG', 'integration-tests', '\
    ${PN}-accuweather \
    ${PN}-acmeda \
    ${PN}-adax \
    ${PN}-adguard \
    ${PN}-advantage-air \
    ${PN}-aemet \
    ${PN}-aftership \
    ${PN}-agent-dvr \
    ${PN}-air-quality \
    ${PN}-airgradient \
    ${PN}-airly \
    ${PN}-airnow \
    ${PN}-airos \
    ${PN}-airq \
    ${PN}-airthings \
    ${PN}-airthings-ble \
    ${PN}-airtouch4 \
    ${PN}-airvisual \
    ${PN}-airvisual-pro \
    ${PN}-airzone \
    ${PN}-airzone-cloud \
    ${PN}-aladdin-connect \
    ${PN}-alarm-control-panel \
    ${PN}-alarmdecoder \
    ${PN}-alert \
    ${PN}-alexa \
    ${PN}-altruist \
    ${PN}-amberelectric \
    ${PN}-ambient-network \
    ${PN}-ambient-station \
    ${PN}-analytics \
    ${PN}-analytics-insights \
    ${PN}-android-ip-webcam \
    ${PN}-androidtv \
    ${PN}-androidtv-remote \
    ${PN}-anova \
    ${PN}-anthemav \
    ${PN}-anthropic \
    ${PN}-aosmith \
    ${PN}-apache-kafka \
    ${PN}-apcupsd \
    ${PN}-apple-tv \
    ${PN}-application-credentials \
    ${PN}-aprilaire \
    ${PN}-aprs \
    ${PN}-apsystems \
    ${PN}-aranet \
    ${PN}-arcam-fmj \
    ${PN}-arve \
    ${PN}-aseko-pool-live \
    ${PN}-asuswrt \
    ${PN}-august \
    ${PN}-aurora \
    ${PN}-aurora-abb-powerone \
    ${PN}-aussie-broadband \
    ${PN}-autarco \
    ${PN}-auth \
    ${PN}-automation \
    ${PN}-awair \
    ${PN}-aws \
    ${PN}-aws-s3 \
    ${PN}-axis \
    ${PN}-azure-data-explorer \
    ${PN}-azure-devops \
    ${PN}-azure-event-hub \
    ${PN}-azure-storage \
    ${PN}-baf \
    ${PN}-balboa \
    ${PN}-bayesian \
    ${PN}-binary-sensor \
    ${PN}-blackbird \
    ${PN}-blebox \
    ${PN}-blink \
    ${PN}-blue-current \
    ${PN}-bluemaestro \
    ${PN}-blueprint \
    ${PN}-bluesound \
    ${PN}-bluetooth-adapters \
    ${PN}-bluetooth-le-tracker \
    ${PN}-bmw-connected-drive \
    ${PN}-bond \
    ${PN}-bosch-alarm \
    ${PN}-bosch-shc \
    ${PN}-braviatv \
    ${PN}-bring \
    ${PN}-broadlink \
    ${PN}-brother \
    ${PN}-brottsplatskartan \
    ${PN}-brunt \
    ${PN}-bryant-evolution \
    ${PN}-bsblan \
    ${PN}-bthome \
    ${PN}-buienradar \
    ${PN}-button \
    ${PN}-caldav \
    ${PN}-calendar \
    ${PN}-cambridge-audio \
    ${PN}-canary \
    ${PN}-cast \
    ${PN}-ccm15 \
    ${PN}-cert-expiry \
    ${PN}-chacon-dio \
    ${PN}-clicksend-tts \
    ${PN}-climate \
    ${PN}-cloudflare \
    ${PN}-co2signal \
    ${PN}-coinbase \
    ${PN}-color-extractor \
    ${PN}-comelit \
    ${PN}-comfoconnect \
    ${PN}-command-line \
    ${PN}-compensation \
    ${PN}-config \
    ${PN}-configurator \
    ${PN}-control4 \
    ${PN}-conversation \
    ${PN}-cookidoo \
    ${PN}-coolmaster \
    ${PN}-counter \
    ${PN}-cover \
    ${PN}-cpuspeed \
    ${PN}-crownstone \
    ${PN}-cups \
    ${PN}-daikin \
    ${PN}-datadog \
    ${PN}-date \
    ${PN}-datetime \
    ${PN}-deako \
    ${PN}-debugpy \
    ${PN}-deconz \
    ${PN}-decora \
    ${PN}-default-config \
    ${PN}-deluge \
    ${PN}-demo \
    ${PN}-denonavr \
    ${PN}-derivative \
    ${PN}-devialet \
    ${PN}-device-automation \
    ${PN}-device-sun-light-trigger \
    ${PN}-device-tracker \
    ${PN}-devolo-home-control \
    ${PN}-devolo-home-network \
    ${PN}-dexcom \
    ${PN}-diagnostics \
    ${PN}-dialogflow \
    ${PN}-directv \
    ${PN}-discord \
    ${PN}-discovergy \
    ${PN}-dlib-face-detect \
    ${PN}-dlib-face-identify \
    ${PN}-dlink \
    ${PN}-dlna-dmr \
    ${PN}-dlna-dms \
    ${PN}-dnsip \
    ${PN}-doorbird \
    ${PN}-dormakaba-dkey \
    ${PN}-downloader \
    ${PN}-dremel-3d-printer \
    ${PN}-drop-connect \
    ${PN}-dsmr-reader \
    ${PN}-duckdns \
    ${PN}-duke-energy \
    ${PN}-dunehd \
    ${PN}-duotecno \
    ${PN}-dwd-weather-warnings \
    ${PN}-dynalite \
    ${PN}-eafm \
    ${PN}-easyenergy \
    ${PN}-ecobee \
    ${PN}-ecoforest \
    ${PN}-econet \
    ${PN}-ecovacs \
    ${PN}-ecowitt \
    ${PN}-eddystone-temperature \
    ${PN}-edl21 \
    ${PN}-efergy \
    ${PN}-eheimdigital \
    ${PN}-eight-sleep \
    ${PN}-electrasmart \
    ${PN}-electric-kiwi \
    ${PN}-elgato \
    ${PN}-elkm1 \
    ${PN}-elmax \
    ${PN}-elvia \
    ${PN}-emoncms \
    ${PN}-emoncms-history \
    ${PN}-emonitor \
    ${PN}-emulated-kasa \
    ${PN}-emulated-roku \
    ${PN}-emulated-hue \
    ${PN}-energenie-power-sockets \
    ${PN}-energy \
    ${PN}-enigma2 \
    ${PN}-enocean \
    ${PN}-enphase-envoy \
    ${PN}-environment-canada \
    ${PN}-epic-games-store \
    ${PN}-epion \
    ${PN}-epson \
    ${PN}-eq3btsmart \
    ${PN}-escea \
    ${PN}-eufylife-ble \
    ${PN}-event \
    ${PN}-everlights \
    ${PN}-evil-genius-labs \
    ${PN}-evohome \
    ${PN}-ezviz \
    ${PN}-faa-delays \
    ${PN}-facebook \
    ${PN}-fail2ban \
    ${PN}-fan \
    ${PN}-fastdotcom \
    ${PN}-feedreader \
    ${PN}-ffmpeg \
    ${PN}-fibaro \
    ${PN}-fido \
    ${PN}-file \
    ${PN}-filesize \
    ${PN}-filter \
    ${PN}-fints \
    ${PN}-fireservicerota \
    ${PN}-firmata \
    ${PN}-fitbit \
    ${PN}-fivem \
    ${PN}-fjaraskupan \
    ${PN}-flexit-bacnet \
    ${PN}-flic \
    ${PN}-flick-electric \
    ${PN}-flipr \
    ${PN}-flo \
    ${PN}-flux \
    ${PN}-flux-led \
    ${PN}-folder \
    ${PN}-folder-watcher \
    ${PN}-foobot \
    ${PN}-forecast-solar \
    ${PN}-forked-daapd \
    ${PN}-foscam \
    ${PN}-freebox \
    ${PN}-freedns \
    ${PN}-freedompro \
    ${PN}-fritz \
    ${PN}-fritzbox \
    ${PN}-fritzbox-callmonitor \
    ${PN}-fronius \
    ${PN}-frontend \
    ${PN}-frontier-silicon \
    ${PN}-fujitsu-fglair \
    ${PN}-fully-kiosk \
    ${PN}-fyta \
    ${PN}-garages-amsterdam \
    ${PN}-gardena-bluetooth \
    ${PN}-generic-hygrostat \
    ${PN}-generic-thermostat \
    ${PN}-geniushub \
    ${PN}-geo-location \
    ${PN}-geocaching \
    ${PN}-geofency \
    ${PN}-gios \
    ${PN}-github \
    ${PN}-glances \
    ${PN}-goalzero \
    ${PN}-gogogate2 \
    ${PN}-goodwe \
    ${PN}-google-assistant \
    ${PN}-google-assistant-sdk \
    ${PN}-google-cloud \
    ${PN}-google-mail \
    ${PN}-google-photos \
    ${PN}-google-pubsub \
    ${PN}-google-sheets \
    ${PN}-google-tasks \
    ${PN}-google-translate \
    ${PN}-google-travel-time \
    ${PN}-google-wifi \
    ${PN}-govee-ble \
    ${PN}-govee-light-local \
    ${PN}-gpsd \
    ${PN}-gpslogger \
    ${PN}-graphite \
    ${PN}-gree \
    ${PN}-greeneye-monitor \
    ${PN}-group \
    ${PN}-growatt-server \
    ${PN}-gstreamer \
    ${PN}-guardian \
    ${PN}-husqvarna-automower-ble \
    ${PN}-ibeacon \
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
        # Add the flaky tests
        packages_list = d.getVar('COMPONENT_TEST_PACKAGES_FLAKY').split()
        for package in packages_list:
            line_to_append = "\npytest --automake tests/components/" + package.removeprefix(d.getVar('PN')+'-').replace('-', '_') + "/"
            package_line = f"  {line_to_append} \n"
            with open(target_file, 'a', encoding='utf-8') as file:
                file.write(package_line)

        # Get the list of non-flaky packages
        packages_list = d.getVar('COMPONENT_TEST_PACKAGES').split()

        # Group packages by first letter after prefix removal
        from collections import defaultdict
        grouped_packages = defaultdict(list)
        pn_prefix = d.getVar('PN') + '-'
        for package in packages_list:
            pkg_name = package.removeprefix(pn_prefix).replace('-', '_')
            if pkg_name:
                first_letter = pkg_name[0].upper()
                grouped_packages[first_letter].append(pkg_name)

        # Only use groups that have at least one package (i.e., only letters with tests)
        with open(target_file, 'a', encoding='utf-8') as file:
            for letter in sorted(grouped_packages):
                pkgs = grouped_packages[letter]
                if pkgs:
                    file.write(f"\n# Tests for integrations starting with '{letter}'\n")
                    file.write("pytest -n auto --automake\\\n")
                    for pkg_name in pkgs:
                        file.write(f"  tests/components/{pkg_name}/ \\\n")
}