PACKAGES += "\
    ${PN}-acer-projector \
    ${PN}-accuweather \
    ${PN}-acmeda \
    ${PN}-adax \
    ${PN}-airthings-ble \
    ${PN}-amazon-polly \
    ${PN}-aruba \
    ${PN}-assist-pipeline \
    ${PN}-axis \
    ${PN}-backup \
    ${PN}-bluesound \
    ${PN}-bluetooth \
    ${PN}-camera \
    ${PN}-cast \
    ${PN}-cisco-ios \
    ${PN}-cloud \
    ${PN}-compensation \
    ${PN}-conversation \
    ${PN}-cpuspeed \
    ${PN}-debugpy \
    ${PN}-dhcp \
    ${PN}-dlna-dmr \
    ${PN}-dlna-dms \
    ${PN}-dunehd \
    ${PN}-evohome \
    ${PN}-ffmpeg \
    ${PN}-folder-watcher \
    ${PN}-fritz \
    ${PN}-fritzbox \
    ${PN}-fritzbox-callmonitor \
    ${PN}-frontend \
    ${PN}-generic \
    ${PN}-github \
    ${PN}-google-mail \
    ${PN}-google-tasks \
    ${PN}-google-translate \
    ${PN}-hacs \
    ${PN}-hardware \
    ${PN}-hue \
    ${PN}-image-upload \
    ${PN}-ipp \
    ${PN}-isal \
    ${PN}-keyboard-remote \
    ${PN}-matter \
    ${PN}-met \
    ${PN}-mobile-app \
    ${PN}-modbus \
    ${PN}-mqtt \
    ${PN}-namecheapdns \
    ${PN}-network \
    ${PN}-norway-air \
    ${PN}-octoprint \
    ${PN}-ohmconnect \
    ${PN}-otp \
    ${PN}-owntracks \
    ${PN}-pandora \
    ${PN}-private-ble-device \
    ${PN}-proxy \
    ${PN}-pulseaudio-loopback \
    ${PN}-qwikswitch \
    ${PN}-radio-browser \
    ${PN}-recorder \
    ${PN}-route53 \
    ${PN}-scrape \
    ${PN}-sentry \
    ${PN}-seven-segments \
    ${PN}-shelly \
    ${PN}-speedtestdotnet \
    ${PN}-sql \
    ${PN}-ssdp \
    ${PN}-startca \
    ${PN}-stream \
    ${PN}-switchbot \
    ${PN}-systemmonitor \
    ${PN}-ted5000 \
    ${PN}-trend \
    ${PN}-tts \
    ${PN}-upnp \
    ${PN}-usb \
    ${PN}-utility-meter \
    ${PN}-vlc \
    ${PN}-zeroconf \
    ${PN}-zestimate \
    ${PN}-zoneminder \
    ${PN}-zwave-js \
    ${PN}-zwave-me \
"

ALLOW_EMPTY:${PN}-acer-projector = "1"
RDEPENDS:${PN}-acer-projector = "\
    python3-pyserial (=3.5) \
"

ALLOW_EMPTY:${PN}-accuweather = "1"
RDEPENDS:${PN}-accuweather = "\
    python3-accuweather (=3.0.0) \
"

ALLOW_EMPTY:${PN}-acmeda = "1"
RDEPENDS:${PN}-acmeda = "\
    python3-aiopulse (=0.4.6) \
"

ALLOW_EMPTY:${PN}-adax = "1"
RDEPENDS:${PN}-adax = "\
    python3-adax (=0.4.0) \
    python3-adax-local (=0.1.5) \
"

ALLOW_EMPTY:${PN}-airthings-ble = "1"
RDEPENDS:${PN}-airthings-ble = "\
    python3-airthings-ble (=0.9.1) \
"

ALLOW_EMPTY:${PN}-amazon-polly = "1"
RDEPENDS:${PN}-amazon-polly = "\
    python3-boto3 (>=1.34.131) \
"

ALLOW_EMPTY:${PN}-aruba = "1"
RDEPENDS:${PN}-aruba = "\
    python3-pexpect (>=4.6.0) \
"

ALLOW_EMPTY:${PN}-assist-pipeline = "1"
RDEPENDS:${PN}-assist-pipeline = "\
    python3-pymicro-vad (=1.0.1) \
    python3-pyspeex-noise (=1.0.2) \
"

ALLOW_EMPTY:${PN}-axis = "1"
RDEPENDS:${PN}-axis = "\
    python3-axis (=62) \
"

ALLOW_EMPTY:${PN}-backup = "1"
RDEPENDS:${PN}-backup = "\
    python3-securetar (=2024.2.1) \
"

ALLOW_EMPTY:${PN}-bluesound = "1"
RDEPENDS:${PN}-bluesound = "\
    python3-pyblu (=0.4.0) \
"

ALLOW_EMPTY:${PN}-bluetooth = "1"
RDEPENDS:${PN}-bluetooth = "\
    python3-bleak (>=0.22.1) \
    python3-bleak-retry-connector (=3.5.0) \
    python3-bluetooth-adapters (=0.19.4) \
    python3-bluetooth-auto-recovery (=1.4.2) \
    python3-bluetooth-data-tools (=1.20.0) \
    python3-dbus-fast (>=2.21.3) \
    python3-habluetooth (=3.4.0) \
"

ALLOW_EMPTY:${PN}-camera = "1"
RDEPENDS:${PN}-camera = "\
    python3-pyturbojpeg (=1.7.5) \
"

ALLOW_EMPTY:${PN}-cast = "1"
RDEPENDS:${PN}-cast = "\
    python3-pychromecast (>=14.0.1) \
"

ALLOW_EMPTY:${PN}-cisco-ios = "1"
RDEPENDS:${PN}-cisco-ios = "\
    python3-pexpect (>=4.6.0) \
"

ALLOW_EMPTY:${PN}-cloud = "1"
RDEPENDS:${PN}-cloud = "\
    python3-hass-nabucasa (=0.81.1) \
"

ALLOW_EMPTY:${PN}-compensation = "1"
RDEPENDS:${PN}-compensation = "\
    python3-numpy (>=1.26.0) \
"

ALLOW_EMPTY:${PN}-conversation = "1"
RDEPENDS:${PN}-conversation = "\
    python3-hassil (>=1.7.4) \
    python3-home-assistant-intents (>=2024.9.4) \
"

ALLOW_EMPTY:${PN}-cpuspeed = "1"
RDEPENDS:${PN}-cpuspeed = "\
    python3-py-cpuinfo (=9.0.0) \
"

ALLOW_EMPTY:${PN}-debugpy = "1"
RDEPENDS:${PN}-debugpy = "\
    python3-debugpy (=1.8.1) \
"

ALLOW_EMPTY:${PN}-dhcp = "1"
RDEPENDS:${PN}-dhcp = "\
    python3-aiodhcpwatcher (=1.0.2) \
    python3-aiodiscover (=2.1.0) \
    python3-cached-ipaddress (=0.5.0) \
"

ALLOW_EMPTY:${PN}-dlna-dmr = "1"
RDEPENDS:${PN}-dlna-dmr = "\
    python3-async-upnp-client (=0.40.0) \
    python3-getmac (=0.9.4) \
"

ALLOW_EMPTY:${PN}-dlna-dms = "1"
RDEPENDS:${PN}-dlna-dms = "\
    python3-async-upnp-client (=0.40.0) \
"

ALLOW_EMPTY:${PN}-dunehd = "1"
RDEPENDS:${PN}-dunehd = "\
    python3-pdunehd (=1.3.2) \
"

ALLOW_EMPTY:${PN}-evohome = "1"
RDEPENDS:${PN}-evohome = "\
    python3-evohome-async (=0.4.20) \
"

ALLOW_EMPTY:${PN}-ffmpeg = "1"
RDEPENDS:${PN}-ffmpeg = "\
    python3-ha-ffmpeg (=3.2.0) \
"

ALLOW_EMPTY:${PN}-folder-watcher = "1"
RDEPENDS:${PN}-folder-watcher = "\
    python3-watchdog (=2.3.1) \
"
# PREFERRED_VERSION_python3_watchdog

ALLOW_EMPTY:${PN}-fritz = "1"
RDEPENDS:${PN}-fritz = "\
    python3-fritzconnection (=1.13.2) \
    python3-xmltodict (=0.13.0) \
"

ALLOW_EMPTY:${PN}-fritzbox = "1"
RDEPENDS:${PN}-fritzbox = "\
    python3-pyfritzhome (=0.6.12) \
"

ALLOW_EMPTY:${PN}-fritzbox-callmonitor = "1"
RDEPENDS:${PN}-fritzbox-callmonitor = "\
    python3-fritzconnection (=1.13.2) \
"

ALLOW_EMPTY:${PN}-frontend = "1"
RDEPENDS:${PN}-frontend = "\
    python3-home-assistant-frontend (=20240909.1) \
"

ALLOW_EMPTY:${PN}-generic = "1"
RDEPENDS:${PN}-generic = "\
    python3-ha-av (=10.1.1) \
    python3-pillow (>=10.3.0) \
"

ALLOW_EMPTY:${PN}-github = "1"
RDEPENDS:${PN}-github = "\
    python3-aiogithubapi (=23.11.0) \
"

ALLOW_EMPTY:${PN}-google-mail = "1"
RDEPENDS:${PN}-google-mail = "\
    python3-google-api-python-client (>=2.71.0) \
"

ALLOW_EMPTY:${PN}-google-tasks = "1"
RDEPENDS:${PN}-google-tasks = "\
    python3-google-api-python-client (>=2.71.0) \
"

ALLOW_EMPTY:${PN}-google-translate = "1"
RDEPENDS:${PN}-google-translate = "\
    python3-gtts (=2.2.4) \
"

ALLOW_EMPTY:${PN}-hacs = "1"
RDEPENDS:${PN}-hacs = "\
    python3-aiogithubapi (=23.11.0) \
"

ALLOW_EMPTY:${PN}-hardware = "1"
RDEPENDS:${PN}-hardware = "\
    python3-psutil-home-assistant (=0.0.1) \
"

ALLOW_EMPTY:${PN}-hue = "1"
RDEPENDS:${PN}-hue = "\
    python3-aiohue (>=4.7.2) \
"

ALLOW_EMPTY:${PN}-image-upload = "1"
RDEPENDS:${PN}-image-upload = "\
    python3-pillow (>=10.3.0) \
"

ALLOW_EMPTY:${PN}-ipp = "1"
RDEPENDS:${PN}-ipp = "\
    python3-pyipp (=0.16.0) \
"

ALLOW_EMPTY:${PN}-isal = "1"
RDEPENDS:${PN}-isal = "\
    python3-isal (=1.6.1) \
"

ALLOW_EMPTY:${PN}-keyboard-remote = "1"
RDEPENDS:${PN}-keyboard-remote = "\
    python3-evdev (>=1.6.1) \
    python3-asyncinotify (>=4.0.2) \
"

ALLOW_EMPTY:${PN}-matter = "1"
RDEPENDS:${PN}-matter = "\
    python3-matter-server (=6.3.0) \
"

ALLOW_EMPTY:${PN}-met = "1"
RDEPENDS:${PN}-met = "\
    python3-pymetno (>=0.12.0) \
"

ALLOW_EMPTY:${PN}-mobile-app = "1"
RDEPENDS:${PN}-mobile-app = "\
    python3-pynacl (=1.5.0) \
"

ALLOW_EMPTY:${PN}-modbus = "1"
RDEPENDS:${PN}-modbus = "\
    python3-pymodbus (>=3.6.8) \
"

ALLOW_EMPTY:${PN}-mqtt = "1"
RDEPENDS:${PN}-mqtt = "\
    python3-paho-mqtt (>=1.6.1) \
"

ALLOW_EMPTY:${PN}-namecheapdns = "1"
RDEPENDS:${PN}-namecheapdns = "\
    python3-defusedxml (=0.7.1) \
"

ALLOW_EMPTY:${PN}-network = "1"
RDEPENDS:${PN}-network = "\
    python3-ifaddr (=0.2.0) \
"

ALLOW_EMPTY:${PN}-norway-air = "1"
RDEPENDS:${PN}-norway-air = "\
    python3-pymetno (>=0.12.0) \
"

ALLOW_EMPTY:${PN}-octoprint = "1"
RDEPENDS:${PN}-octoprint = "\
    python3-pyoctoprintapi (=0.1.12) \
"

ALLOW_EMPTY:${PN}-ohmconnect = "1"
RDEPENDS:${PN}-ohmconnect = "\
    python3-defusedxml (=0.7.1) \
"

ALLOW_EMPTY:${PN}-otp = "1"
RDEPENDS:${PN}-otp = "\
    python3-pyotp (=2.8.0) \
"

ALLOW_EMPTY:${PN}-owntracks = "1"
RDEPENDS:${PN}-owntracks = "\
    python3-pynacl (=1.5.0) \
"

ALLOW_EMPTY:${PN}-pandora = "1"
RDEPENDS:${PN}-pandora = "\
    python3-pexpect (>=4.6.0) \
"

ALLOW_EMPTY:${PN}-private-ble-device = "1"
RDEPENDS:${PN}-private-ble-device = "\
    python3-bluetooth-data-tools (=1.20.0) \
"

ALLOW_EMPTY:${PN}-proxy = "1"
RDEPENDS:${PN}-proxy = "\
    python3-pillow (>=10.3.0) \
"

ALLOW_EMPTY:${PN}-pulseaudio-loopback = "1"
RDEPENDS:${PN}-pulseaudio-loopback = "\
    python3-pulsectl (>=23.5.2) \
"

ALLOW_EMPTY:${PN}-qwikswitch = "1"
RDEPENDS:${PN}-qwikswitch = "\
    python3-pyqwikswitch (>=0.93) \
"

ALLOW_EMPTY:${PN}-radio-browser = "1"
RDEPENDS:${PN}-radio-browser = "\
    python3-radios (=0.3.1) \
"

ALLOW_EMPTY:${PN}-recorder = "1"
RDEPENDS:${PN}-recorder = "\
    python3-sqlite3 \
    python3-fnv-hash-fast (=1.0.2) \
    python3-sqlalchemy (>=2.0.30) \
    python3-psutil-home-assistant (=0.0.1) \
"

ALLOW_EMPTY:${PN}-route53 = "1"
RDEPENDS:${PN}-route53 = "\
    python3-boto3 (>=1.34.131) \
"

ALLOW_EMPTY:${PN}-scrape = "1"
RDEPENDS:${PN}-scrape = "\
    python3-beautifulsoup4 (>=4.12.3) \
    python3-lxml (>=5.1.0) \
"

ALLOW_EMPTY:${PN}-sentry = "1"
RDEPENDS:${PN}-sentry = "\
    python3-sentry-sdk (>=1.40.3) \
"

ALLOW_EMPTY:${PN}-seven-segments = "1"
RDEPENDS:${PN}-seven-segments = "\
    python3-pillow (>=10.3.0) \
"

ALLOW_EMPTY:${PN}-shelly = "1"
RDEPENDS:${PN}-shelly = "\
    python3-aioshelly (=11.4.2) \
"

ALLOW_EMPTY:${PN}-speedtestdotnet = "1"
RDEPENDS:${PN}-speedtestdotnet = "\
    python3-speedtest-cli (=2.1.3) \
"

ALLOW_EMPTY:${PN}-sql = "1"
RDEPENDS:${PN}-sql = "\
    python3-sqlalchemy (>=2.0.30) \
    python3-sqlparse (>=0.5.0) \
"

ALLOW_EMPTY:${PN}-ssdp = "1"
RDEPENDS:${PN}-ssdp = "\
    python3-async-upnp-client (=0.40.0) \
"

ALLOW_EMPTY:${PN}-startca = "1"
RDEPENDS:${PN}-startca = "\
    python3-xmltodict (=0.13.0) \
"

ALLOW_EMPTY:${PN}-stream = "1"
RDEPENDS:${PN}-stream = "\
    python3-pyturbojpeg (=1.7.5) \
    python3-ha-av (=10.1.1) \
    python3-numpy (>=1.26.0) \
"

ALLOW_EMPTY:${PN}-switchbot = "1"
RDEPENDS:${PN}-switchbot = "\
    python3-pyswitchbot (=0.48.2) \
"

ALLOW_EMPTY:${PN}-systemmonitor = "1"
RDEPENDS:${PN}-systemmonitor = "\
    python3-psutil (>=5.9.8) \
    python3-psutil-home-assistant (=0.0.1) \
"

ALLOW_EMPTY:${PN}-ted5000 = "1"
RDEPENDS:${PN}-ted5000 = "\
    python3-xmltodict (=0.13.0) \
"

ALLOW_EMPTY:${PN}-trend = "1"
RDEPENDS:${PN}-trend = "\
    python3-numpy (>=1.26.0) \
"

ALLOW_EMPTY:${PN}-tts = "1"
RDEPENDS:${PN}-tts = "\
    python3-mutagen (=1.47.0) \
"

ALLOW_EMPTY:${PN}-upnp = "1"
RDEPENDS:${PN}-upnp = "\
    python3-async-upnp-client (=0.40.0) \
    python3-getmac (=0.9.4) \
"

ALLOW_EMPTY:${PN}-usb = "1"
RDEPENDS:${PN}-usb = "\
    python3-pyserial (=3.5) \
    python3-pyudev (>=0.24.1) \
"

ALLOW_EMPTY:${PN}-utility-meter = "1"
RDEPENDS:${PN}-utility-meter = "\
    python3-croniter (>=2.0.2) \
"

ALLOW_EMPTY:${PN}-vlc = "1"
RDEPENDS:${PN}-vlc = "\
    python3-python-vlc (>=3.0.18122) \
"

ALLOW_EMPTY:${PN}-zeroconf = "1"
RDEPENDS:${PN}-zeroconf = "\
    python3-zeroconf (>=0.133.0) \
"

ALLOW_EMPTY:${PN}-zestimate = "1"
RDEPENDS:${PN}-zestimate = "\
    python3-xmltodict (=0.13.0) \
"

ALLOW_EMPTY:${PN}-zoneminder = "1"
RDEPENDS:${PN}-zoneminder = "\
    python3-zm-py (=0.5.4) \
"

ALLOW_EMPTY:${PN}-zwave-js = "1"
RDEPENDS:${PN}-zwave-js = "\
    python3-pyserial (=3.5) \
    python3-zwave-js-server-python (=0.57.0) \
"

ALLOW_EMPTY:${PN}-zwave-me = "1"
RDEPENDS:${PN}-zwave-me = "\
    python3-url-normalize (=1.4.3) \
    python3-zwave-me-ws (=0.4.3) \
"

RDEPENDS:${PN} += "\
    ${PN}-assist-pipeline \
    ${PN}-bluetooth \
    ${PN}-cloud \
    ${PN}-conversation \
    ${PN}-dhcp \
    ${PN}-ffmpeg \
    ${PN}-frontend \
    ${PN}-google-translate \
    ${PN}-hardware \
    ${PN}-image-upload \
    ${PN}-matter \
    ${PN}-mobile-app \
    ${PN}-radio-browser \
    ${PN}-recorder \
    ${PN}-stream \
    ${PN}-usb \
    ${PN}-zeroconf \
"

RRECOMMENDS:${PN} += "\
    ${PN}-acer-projector \
    ${PN}-accuweather \
    ${PN}-acmeda \
    ${PN}-adax \
    ${PN}-airthings-ble \
    ${PN}-aruba \
    ${PN}-amazon-polly \
    ${PN}-axis \
    ${PN}-backup \
    ${PN}-bluesound \
    ${PN}-camera \
    ${PN}-cast \
    ${PN}-cisco-ios \
    ${PN}-compensation \
    ${PN}-cpuspeed \
    ${PN}-debugpy \
    ${PN}-dlna-dmr \
    ${PN}-dlna-dms \
    ${PN}-dunehd \
    ${PN}-evohome \
    ${PN}-folder-watcher \
    ${PN}-fritz \
    ${PN}-fritzbox \
    ${PN}-fritzbox-callmonitor \
    ${PN}-generic \
    ${PN}-github \
    ${PN}-google-mail \
    ${PN}-google-tasks \
    ${PN}-hacs \
    ${PN}-hue \
    ${PN}-ipp \
    ${PN}-isal \
    ${PN}-keyboard-remote \
    ${PN}-met \
    ${PN}-modbus \
    ${PN}-mqtt \
    ${PN}-namecheapdns \
    ${PN}-network \
    ${PN}-norway-air \
    ${PN}-octoprint \
    ${PN}-ohmconnect \
    ${PN}-otp \
    ${PN}-owntracks \
    ${PN}-pandora \
    ${PN}-private-ble-device \
    ${PN}-proxy \
    ${PN}-pulseaudio-loopback \
    ${PN}-qwikswitch \
    ${PN}-route53 \
    ${PN}-scrape \
    ${PN}-sentry \
    ${PN}-seven-segments \
    ${PN}-shelly \
    ${PN}-speedtestdotnet \
    ${PN}-sql \
    ${PN}-startca \
    ${PN}-ssdp \
    ${PN}-switchbot \
    ${PN}-systemmonitor \
    ${PN}-ted5000 \
    ${PN}-trend \
    ${PN}-tts \
    ${PN}-upnp \
    ${PN}-utility-meter \
    ${PN}-vlc \
    ${PN}-zestimate \
    ${PN}-zoneminder \
    ${PN}-zwave-js \
    ${PN}-zwave-me \
"