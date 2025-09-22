PACKAGECONFIG ??= ""
PACKAGECONFIG[integration-tests] = ",,,"

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
    ${PN}-ai-task \
    ${PN}-air-quality \
    ${PN}-airgradient \
    ${PN}-airly \
    ${PN}-airnow \
    ${PN}-airos \
    ${PN}-airq \
    ${PN}-airthings \
    ${PN}-airthings-ble \
    ${PN}-airtouch4 \
    ${PN}-airtouch5 \
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
    ${PN}-backup \
    ${PN}-baf \
    ${PN}-balboa \
    ${PN}-bang-olufsen \
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
    ${PN}-camera \
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
    ${PN}-dhcp \
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
    ${PN}-dsmr \
    ${PN}-dsmr-reader \
    ${PN}-duckdns \
    ${PN}-duke-energy \
    ${PN}-dunehd \
    ${PN}-duotecno \
    ${PN}-dwd-weather-warnings \
    ${PN}-dynalite \
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
            file.write("\npytest -n auto --automake --disable-pytest-warnings\\\n")

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