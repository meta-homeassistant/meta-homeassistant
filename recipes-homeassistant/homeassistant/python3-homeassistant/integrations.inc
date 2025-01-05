PACKAGES += "\
    ${PN}-acaia \
    ${PN}-acer-projector \
    ${PN}-accuweather \
    ${PN}-acmeda \
    ${PN}-adax \
    ${PN}-adguard \
    ${PN}-advantage-air \
    ${PN}-aemet \
    ${PN}-aftership \
    ${PN}-agent-dvr \
    ${PN}-airgradient \
    ${PN}-airly \
    ${PN}-airnow \
    ${PN}-airq \
    ${PN}-airthings \
    ${PN}-airthings-ble \
    ${PN}-airtouch4 \
    ${PN}-airtouch5 \
    ${PN}-airvisual \
    ${PN}-airvisual-pro \
    ${PN}-airzone \
    ${PN}-airzone-cloud \
    ${PN}-alarmdecoder \
    ${PN}-alpha-vantage \
    ${PN}-amazon-polly \
    ${PN}-aruba \
    ${PN}-assist-pipeline \
    ${PN}-axis \
    ${PN}-backup \
    ${PN}-bluesound \
    ${PN}-bluetooth \
    ${PN}-bluetooth-tracker \
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
    ${PN}-go2rtc \
    ${PN}-generic \
    ${PN}-github \
    ${PN}-google-mail \
    ${PN}-google-sheets \
    ${PN}-google-tasks \
    ${PN}-google-translate \
    ${PN}-hardware \
    ${PN}-hue \
    ${PN}-image-upload \
    ${PN}-ipp \
    ${PN}-isal \
    ${PN}-keyboard-remote \
    ${PN}-kwb \
    ${PN}-matter \
    ${PN}-met \
    ${PN}-mobile-app \
    ${PN}-modbus \
    ${PN}-mqtt \
    ${PN}-namecheapdns \
    ${PN}-network \
    ${PN}-nmap-tracker \
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
    ${PN}-trafikverket-camera \
    ${PN}-trafikverket-ferry \
    ${PN}-trafikverket-train \
    ${PN}-trafikverket-weatherstation \
    ${PN}-trend \
    ${PN}-tts \
    ${PN}-upnp \
    ${PN}-usb \
    ${PN}-utility-meter \
    ${PN}-vlc \
    ${PN}-zabbix \
    ${PN}-zeroconf \
    ${PN}-zestimate \
    ${PN}-zha \
    ${PN}-zoneminder \
    ${PN}-zwave-js \
    ${PN}-zwave-me \
"

ALLOW_EMPTY:${PN}-acaia = "1"
RDEPENDS:${PN}-acaia = "\
    python3-aioacaia (=0.1.13) \
"

ALLOW_EMPTY:${PN}-accuweather = "1"
RDEPENDS:${PN}-accuweather = "\
    python3-accuweather (=4.0.0) \
"

ALLOW_EMPTY:${PN}-acer-projector = "1"
RDEPENDS:${PN}-acer-projector = "\
    python3-pyserial (=3.5) \
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

ALLOW_EMPTY:${PN}-adguard = "1"
RDEPENDS:${PN}-adguard = "\
    python3-adguardhome (=0.7.0) \
"

ALLOW_EMPTY:${PN}-advantage-air = "1"
RDEPENDS:${PN}-advantage-air = "\
    python3-advantage-air (=0.4.4) \
"

ALLOW_EMPTY:${PN}-aemet = "1"
RDEPENDS:${PN}-aemet = "\
    python3-aemet-opendata (=0.6.4) \
"

ALLOW_EMPTY:${PN}-aftership = "1"
RDEPENDS:${PN}-aftership = "\
    python3-pyaftership (>=21.11.0) \
"

ALLOW_EMPTY:${PN}-agent-dvr = "1"
RDEPENDS:${PN}-agent-dvr = "\
    python3-agent-py (=0.0.24) \
"

ALLOW_EMPTY:${PN}-airgradient = "1"
RDEPENDS:${PN}-airgradient = "\
    python3-airgradient (=0.9.1) \
"

ALLOW_EMPTY:${PN}-airly = "1"
RDEPENDS:${PN}-airly = "\
    python3-airly (=1.1.0) \
"

ALLOW_EMPTY:${PN}-airnow = "1"
RDEPENDS:${PN}-airnow = "\
    python3-pyairnow (>=1.2.1) \
"

ALLOW_EMPTY:${PN}-airq = "1"
RDEPENDS:${PN}-airq = "\
    python3-aioairq (=0.4.3) \
"

ALLOW_EMPTY:${PN}-airthings = "1"
RDEPENDS:${PN}-airthings = "\
    python3-airthings-cloud (=0.2.0) \
"

ALLOW_EMPTY:${PN}-airthings-ble = "1"
RDEPENDS:${PN}-airthings-ble = "\
    python3-airthings-ble (=0.9.2) \
"

ALLOW_EMPTY:${PN}-airtouch4 = "1"
RDEPENDS:${PN}-airtouch4 = "\
    python3-airtouch4pyapi (>=1.0.5) \
"

ALLOW_EMPTY:${PN}-airtouch5 = "1"
RDEPENDS:${PN}-airtouch5 = "\
    python3-airtouch5py (=0.2.11) \
"

ALLOW_EMPTY:${PN}-airvisual = "1"
RDEPENDS:${PN}-airvisual = "\
    python3-pyairvisual (=2023.08.1) \
"

ALLOW_EMPTY:${PN}-airvisual-pro = "1"
RDEPENDS:${PN}-airvisual-pro = "\
    python3-pyairvisual (=2023.08.1) \
"

ALLOW_EMPTY:${PN}-airzone = "1"
RDEPENDS:${PN}-airzone = "\
    python3-aioairzone (=0.9.7) \
"

ALLOW_EMPTY:${PN}-airzone-cloud = "1"
RDEPENDS:${PN}-airzone-cloud = "\
    python3-aioairzone-cloud (=0.6.10) \
"

ALLOW_EMPTY:${PN}-alarmdecoder = "1"
RDEPENDS:${PN}-alarmdecoder = "\
    python3-adext (=0.4.3) \
"

ALLOW_EMPTY:${PN}-alpha-vantage = "1"
RDEPENDS:${PN}-alpha-vantage = "\
    python3-alpha-vantage (>=2.3.1) \
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
    python3-axis (=64) \
"

ALLOW_EMPTY:${PN}-backup = "1"
RDEPENDS:${PN}-backup = "\
    python3-cronsim (>=2.6) \
    python3-securetar (=2024.11.0) \
"

ALLOW_EMPTY:${PN}-bluesound = "1"
RDEPENDS:${PN}-bluesound = "\
    python3-pyblu (=2.0.0) \
"

ALLOW_EMPTY:${PN}-bluetooth = "1"
RDEPENDS:${PN}-bluetooth = "\
    python3-bleak (>=0.22.3) \
    python3-bleak-retry-connector (=3.6.0) \
    python3-bluetooth-adapters (=0.20.2) \
    python3-bluetooth-auto-recovery (=1.4.2) \
    python3-bluetooth-data-tools (=1.20.0) \
    python3-dbus-fast (>=2.24.3) \
    python3-habluetooth (=3.6.0) \
"

ALLOW_EMPTY:${PN}-bluetooth-tracker = "1"
RDEPENDS:${PN}-bluetooth-tracker = "\
    python3-bt-proximity (=0.2.1) \
    python3-pybluez (>=0.22) \
"

ALLOW_EMPTY:${PN}-camera = "1"
RDEPENDS:${PN}-camera = "\
    python3-pyturbojpeg (=1.7.5) \
"

ALLOW_EMPTY:${PN}-cast = "1"
RDEPENDS:${PN}-cast = "\
    python3-pychromecast (>=14.0.5) \
"

ALLOW_EMPTY:${PN}-cisco-ios = "1"
RDEPENDS:${PN}-cisco-ios = "\
    python3-pexpect (>=4.6.0) \
"

ALLOW_EMPTY:${PN}-cloud = "1"
RDEPENDS:${PN}-cloud = "\
    python3-hass-nabucasa (=0.87.0) \
"

ALLOW_EMPTY:${PN}-compensation = "1"
RDEPENDS:${PN}-compensation = "\
    python3-numpy (>=2.2.0) \
"

ALLOW_EMPTY:${PN}-conversation = "1"
RDEPENDS:${PN}-conversation = "\
    python3-hassil (>=2.1.0) \
    python3-home-assistant-intents (>=2025.1.1) \
"

ALLOW_EMPTY:${PN}-cpuspeed = "1"
RDEPENDS:${PN}-cpuspeed = "\
    python3-py-cpuinfo (=9.0.0) \
"

ALLOW_EMPTY:${PN}-debugpy = "1"
RDEPENDS:${PN}-debugpy = "\
    python3-debugpy (=1.8.11) \
"

ALLOW_EMPTY:${PN}-dhcp = "1"
RDEPENDS:${PN}-dhcp = "\
    python3-aiodhcpwatcher (=1.0.2) \
    python3-aiodiscover (=2.1.0) \
    python3-cached-ipaddress (=0.8.0) \
"

ALLOW_EMPTY:${PN}-dlna-dmr = "1"
RDEPENDS:${PN}-dlna-dmr = "\
    python3-async-upnp-client (=0.42.0) \
    python3-getmac (=0.9.4) \
"

ALLOW_EMPTY:${PN}-dlna-dms = "1"
RDEPENDS:${PN}-dlna-dms = "\
    python3-async-upnp-client (=0.42.0) \
"

ALLOW_EMPTY:${PN}-dunehd = "1"
RDEPENDS:${PN}-dunehd = "\
    python3-pdunehd (=1.3.2) \
"

ALLOW_EMPTY:${PN}-evohome = "1"
RDEPENDS:${PN}-evohome = "\
    python3-evohome-async (=0.4.21) \
"

ALLOW_EMPTY:${PN}-ffmpeg = "1"
RDEPENDS:${PN}-ffmpeg = "\
    python3-ha-ffmpeg (=3.2.2) \
"

ALLOW_EMPTY:${PN}-folder-watcher = "1"
RDEPENDS:${PN}-folder-watcher = "\
    python3-watchdog (=6.0.0) \
"

ALLOW_EMPTY:${PN}-fritz = "1"
RDEPENDS:${PN}-fritz = "\
    python3-fritzconnection (=1.14.0) \
    python3-xmltodict (>=0.13.0) \
"

ALLOW_EMPTY:${PN}-fritzbox = "1"
RDEPENDS:${PN}-fritzbox = "\
    python3-pyfritzhome (=0.6.12) \
"

ALLOW_EMPTY:${PN}-fritzbox-callmonitor = "1"
RDEPENDS:${PN}-fritzbox-callmonitor = "\
    python3-fritzconnection (=1.14.0) \
"

ALLOW_EMPTY:${PN}-frontend = "1"
RDEPENDS:${PN}-frontend = "\
    python3-home-assistant-frontend (>=20250103.0) \
"

ALLOW_EMPTY:${PN}-generic = "1"
RDEPENDS:${PN}-generic = "\
    python3-av (=13.1.0) \
    python3-pillow (>=11.0.0) \
"

ALLOW_EMPTY:${PN}-github = "1"
RDEPENDS:${PN}-github = "\
    python3-aiogithubapi (=24.6.0) \
"

ALLOW_EMPTY:${PN}-go2rtc = "1"
RDEPENDS:${PN}-go2rtc = "\
    python3-go2rtc-client (>=0.1.2) \
"

ALLOW_EMPTY:${PN}-google-mail = "1"
RDEPENDS:${PN}-google-mail = "\
    python3-google-api-python-client (>=2.71.0) \
"

ALLOW_EMPTY:${PN}-google-sheets = "1"
RDEPENDS:${PN}-google-sheets = "\
    python3-gspread (>=5.5.0) \
"

ALLOW_EMPTY:${PN}-google-tasks = "1"
RDEPENDS:${PN}-google-tasks = "\
    python3-google-api-python-client (>=2.71.0) \
"

ALLOW_EMPTY:${PN}-google-translate = "1"
RDEPENDS:${PN}-google-translate = "\
    python3-gtts (=2.2.4) \
"

ALLOW_EMPTY:${PN}-hardware = "1"
RDEPENDS:${PN}-hardware = "\
    python3-psutil-home-assistant (=0.0.1) \
"

ALLOW_EMPTY:${PN}-hue = "1"
RDEPENDS:${PN}-hue = "\
    python3-aiohue (>=4.7.3) \
"

ALLOW_EMPTY:${PN}-image-upload = "1"
RDEPENDS:${PN}-image-upload = "\
    python3-pillow (>=11.0.0) \
"

ALLOW_EMPTY:${PN}-ipp = "1"
RDEPENDS:${PN}-ipp = "\
    python3-pyipp (=0.17.0) \
"

ALLOW_EMPTY:${PN}-isal = "1"
RDEPENDS:${PN}-isal = "\
    python3-isal (=1.7.1) \
"

ALLOW_EMPTY:${PN}-keyboard-remote = "1"
RDEPENDS:${PN}-keyboard-remote = "\
    python3-evdev (>=1.6.1) \
    python3-asyncinotify (>=4.0.2) \
"

ALLOW_EMPTY:${PN}-kwb = "1"
RDEPENDS:${PN}-kwb = "\
    python3-pykwb (=0.0.8) \
"

ALLOW_EMPTY:${PN}-matter = "1"
RDEPENDS:${PN}-matter = "\
    python3-python-matter-server (=6.6.0) \
"

ALLOW_EMPTY:${PN}-met = "1"
RDEPENDS:${PN}-met = "\
    python3-pymetno (>=0.13.0) \
"

ALLOW_EMPTY:${PN}-mobile-app = "1"
RDEPENDS:${PN}-mobile-app = "\
    python3-pynacl (=1.5.0) \
"

ALLOW_EMPTY:${PN}-modbus = "1"
RDEPENDS:${PN}-modbus = "\
    python3-pymodbus (>=3.7.4) \
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

ALLOW_EMPTY:${PN}-nmap-tracker = "1"
RDEPENDS:${PN}-nmap-tracker = "\
    python3-aiooui (=0.1.7) \
    python3-getmac (=0.9.4) \
    python3-netmap (=0.7.0.2) \
"

ALLOW_EMPTY:${PN}-norway-air = "1"
RDEPENDS:${PN}-norway-air = "\
    python3-pymetno (>=0.13.0) \
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
    python3-pillow (>=11.0.0) \
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
    python3-radios (=0.3.2) \
    python3-pycountry (=24.6.1) \
"

ALLOW_EMPTY:${PN}-recorder = "1"
RDEPENDS:${PN}-recorder = "\
    python3-sqlite3 \
    python3-fnv-hash-fast (=1.0.2) \
    python3-sqlalchemy (>=2.0.36) \
    python3-psutil-home-assistant (=0.0.1) \
"

ALLOW_EMPTY:${PN}-route53 = "1"
RDEPENDS:${PN}-route53 = "\
    python3-boto3 (>=1.34.131) \
"

ALLOW_EMPTY:${PN}-scrape = "1"
RDEPENDS:${PN}-scrape = "\
    python3-beautifulsoup4 (>=4.12.3) \
    python3-lxml (>=5.3.0) \
"

ALLOW_EMPTY:${PN}-sentry = "1"
RDEPENDS:${PN}-sentry = "\
    python3-sentry-sdk (>=1.40.3) \
"

ALLOW_EMPTY:${PN}-seven-segments = "1"
RDEPENDS:${PN}-seven-segments = "\
    python3-pillow (>=11.0.0) \
"

ALLOW_EMPTY:${PN}-shelly = "1"
RDEPENDS:${PN}-shelly = "\
    python3-aioshelly (=12.2.0) \
"

ALLOW_EMPTY:${PN}-speedtestdotnet = "1"
RDEPENDS:${PN}-speedtestdotnet = "\
    python3-speedtest-cli (=2.1.3) \
"

ALLOW_EMPTY:${PN}-sql = "1"
RDEPENDS:${PN}-sql = "\
    python3-sqlalchemy (>=2.0.36) \
    python3-sqlparse (>=0.5.0) \
"

ALLOW_EMPTY:${PN}-ssdp = "1"
RDEPENDS:${PN}-ssdp = "\
    python3-async-upnp-client (=0.42.0) \
"

ALLOW_EMPTY:${PN}-startca = "1"
RDEPENDS:${PN}-startca = "\
    python3-xmltodict (>=0.13.0) \
"

ALLOW_EMPTY:${PN}-stream = "1"
RDEPENDS:${PN}-stream = "\
    python3-pyturbojpeg (=1.7.5) \
    python3-av (=13.1.0) \
    python3-numpy (>=2.2.0) \
"

ALLOW_EMPTY:${PN}-switchbot = "1"
RDEPENDS:${PN}-switchbot = "\
    python3-pyswitchbot (=0.55.4) \
"

ALLOW_EMPTY:${PN}-systemmonitor = "1"
RDEPENDS:${PN}-systemmonitor = "\
    python3-psutil (>=6.1.0) \
    python3-psutil-home-assistant (=0.0.1) \
"

ALLOW_EMPTY:${PN}-ted5000 = "1"
RDEPENDS:${PN}-ted5000 = "\
    python3-xmltodict (>=0.13.0) \
"

ALLOW_EMPTY:${PN}-trafikverket-camera = "1"
RDEPENDS:${PN}-trafikverket-camera = "\
    python3-pytrafikverket (=1.1.1) \
"

ALLOW_EMPTY:${PN}-trafikverket-ferry = "1"
RDEPENDS:${PN}-trafikverket-ferry = "\
    python3-pytrafikverket (=1.1.1) \
"

ALLOW_EMPTY:${PN}-trafikverket-train = "1"
RDEPENDS:${PN}-trafikverket-train = "\
    python3-pytrafikverket (=1.1.1) \
"

ALLOW_EMPTY:${PN}-trafikverket-weatherstation = "1"
RDEPENDS:${PN}-trafikverket-weatherstation = "\
    python3-pytrafikverket (=1.1.1) \
"

ALLOW_EMPTY:${PN}-trend = "1"
RDEPENDS:${PN}-trend = "\
    python3-numpy (>=2.2.0) \
"

ALLOW_EMPTY:${PN}-tts = "1"
RDEPENDS:${PN}-tts = "\
    python3-mutagen (=1.47.0) \
"

ALLOW_EMPTY:${PN}-upnp = "1"
RDEPENDS:${PN}-upnp = "\
    python3-async-upnp-client (=0.42.0) \
    python3-getmac (=0.9.4) \
"

ALLOW_EMPTY:${PN}-usb = "1"
RDEPENDS:${PN}-usb = "\
    python3-pyserial (=3.5) \
    python3-pyudev (>=0.24.1) \
"

ALLOW_EMPTY:${PN}-utility-meter = "1"
RDEPENDS:${PN}-utility-meter = "\
    python3-cronsim (>=2.6) \
"

ALLOW_EMPTY:${PN}-vlc = "1"
RDEPENDS:${PN}-vlc = "\
    python3-python-vlc (>=3.0.18122) \
"

ALLOW_EMPTY:${PN}-zabbix = "1"
RDEPENDS:${PN}-zabbix = "\
    python3-py-zabbix (=1.1.7) \
"

ALLOW_EMPTY:${PN}-zeroconf = "1"
RDEPENDS:${PN}-zeroconf = "\
    python3-zeroconf (>=0.136.2) \
"

ALLOW_EMPTY:${PN}-zestimate = "1"
RDEPENDS:${PN}-zestimate = "\
    python3-xmltodict (>=0.13.0) \
"

ALLOW_EMPTY:${PN}-zha = "1"
RDEPENDS:${PN}-zha = "\
    python3-zha (>=0.0.44) \
    python3-universal-silabs-flasher (>=0.0.25) \
"

ALLOW_EMPTY:${PN}-zoneminder = "1"
RDEPENDS:${PN}-zoneminder = "\
    python3-zm-py (=0.5.4) \
"

ALLOW_EMPTY:${PN}-zwave-js = "1"
RDEPENDS:${PN}-zwave-js = "\
    python3-pyserial (=3.5) \
    python3-zwave-js-server-python (=0.60.0) \
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
    ${PN}-go2rtc \
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
    ${PN}-acaia \
    ${PN}-accuweather \
    ${PN}-acer-projector \
    ${PN}-acmeda \
    ${PN}-adax \
    ${PN}-adguard \
    ${PN}-advantage-air \
    ${PN}-aemet \
    ${PN}-aftership \
    ${PN}-agent-dvr \
    ${PN}-airgradient \
    ${PN}-airly \
    ${PN}-airnow \
    ${PN}-airq \
    ${PN}-airthings \
    ${PN}-airthings-ble \
    ${PN}-airtouch4 \
    ${PN}-airtouch5 \
    ${PN}-airvisual \
    ${PN}-airvisual-pro \    
    ${PN}-airzone \    
    ${PN}-airzone-cloud \    
    ${PN}-alarmdecoder \    
    ${PN}-alpha-vantage \    
    ${PN}-aruba \
    ${PN}-amazon-polly \
    ${PN}-axis \
    ${PN}-backup \
    ${PN}-bluesound \
    ${PN}-bluetooth-tracker \
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
    ${PN}-google-sheets \
    ${PN}-google-tasks \
    ${PN}-hue \
    ${PN}-ipp \
    ${PN}-isal \
    ${PN}-keyboard-remote \
    ${PN}-kwb \
    ${PN}-met \
    ${PN}-modbus \
    ${PN}-mqtt \
    ${PN}-namecheapdns \
    ${PN}-network \
    ${PN}-nmap-tracker \
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
    ${PN}-trafikverket-camera \
    ${PN}-trafikverket-ferry \
    ${PN}-trafikverket-train \
    ${PN}-trafikverket-weatherstation \
    ${PN}-trend \
    ${PN}-tts \
    ${PN}-upnp \
    ${PN}-utility-meter \
    ${PN}-vlc \
    ${PN}-zabbix \
    ${PN}-zestimate \
    ${PN}-zha \
    ${PN}-zoneminder \
    ${PN}-zwave-js \
    ${PN}-zwave-me \
"