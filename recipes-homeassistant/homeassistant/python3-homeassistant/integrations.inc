PACKAGES += "\
    ${PN}-amazon-polly \
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
    ${PN}-hacs \
    ${PN}-hardware \
    ${PN}-hue \
    ${PN}-image-upload \
    ${PN}-ipp \
    ${PN}-keyboard-remote \
    ${PN}-matter \
    ${PN}-met \
    ${PN}-mobile-app \
    ${PN}-modbus \
    ${PN}-octoprint \
    ${PN}-otp \
    ${PN}-pulseaudio-loopback \
    ${PN}-radio-browser \
    ${PN}-recorder \
    ${PN}-route53 \
    ${PN}-scrape \
    ${PN}-sentry \
    ${PN}-shelly \
    ${PN}-ssdp \
    ${PN}-stream \
    ${PN}-systemmonitor \
    ${PN}-tts \
    ${PN}-upnp \
    ${PN}-usb \
    ${PN}-vlc \
    ${PN}-zeroconf \
"

ALLOW_EMPTY:${PN}-amazon-polly = "1"
RDEPENDS:${PN}-amazon-polly = "\
    python3-boto3 (>=1.34.51) \
"

ALLOW_EMPTY:${PN}-assist-pipeline = "1"
RDEPENDS:${PN}-assist-pipeline = "\
    python3-webrtc-noise-gain (>=1.2.3) \
"

ALLOW_EMPTY:${PN}-axis = "1"
RDEPENDS:${PN}-axis = "\
    python3-axis (=61) \
"

ALLOW_EMPTY:${PN}-backup = "1"
RDEPENDS:${PN}-backup = "\
    python3-securetar (=2024.2.1) \
"

ALLOW_EMPTY:${PN}-bluetooth = "1"
RDEPENDS:${PN}-bluetooth = "\
    python3-bleak (=0.21.1) \
    python3-bleak-retry-connector (=3.5.0) \
    python3-bluetooth-adapters (=0.19.2) \
    python3-bluetooth-auto-recovery (=1.4.2) \
    python3-bluetooth-data-tools (=1.19.0) \
    python3-dbus-fast (>=2.21.1) \
    python3-habluetooth (=2.8.1) \
"

ALLOW_EMPTY:${PN}-cast = "1"
RDEPENDS:${PN}-cast = "\
    python3-pychromecast (>=14.0.1) \
"

ALLOW_EMPTY:${PN}-cloud = "1"
RDEPENDS:${PN}-cloud = "\
    python3-hass-nabucasa (=0.78.0) \
"

ALLOW_EMPTY:${PN}-conversation = "1"
RDEPENDS:${PN}-conversation = "\
    python3-hassil (>=1.6.1) \
    python3-home-assistant-intents (>=2024.4.24) \
"

ALLOW_EMPTY:${PN}-debugpy = "1"
RDEPENDS:${PN}-debugpy = "\
    python3-debugpy (=1.8.1) \
"

ALLOW_EMPTY:${PN}-dhcp = "1"
RDEPENDS:${PN}-dhcp = "\
    python3-aiodhcpwatcher (=1.0.0) \
    python3-aiodiscover (=2.1.0) \
    python3-cached-ipaddress (=0.3.0) \
"

ALLOW_EMPTY:${PN}-ffmpeg = "1"
RDEPENDS:${PN}-ffmpeg = "\
    python3-ha-ffmpeg (=3.2.0) \
"

ALLOW_EMPTY:${PN}-file-upload = "1"
RDEPENDS:${PN}-file-upload = "\
    python3-janus (=1.0.0) \
"

ALLOW_EMPTY:${PN}-fritz = "1"
RDEPENDS:${PN}-fritz = "\
    python3-fritzconnection (=1.13.2) \
    python3-xmltodict (=0.13.0) \
"

ALLOW_EMPTY:${PN}-fritzbox = "1"
RDEPENDS:${PN}-fritzbox = "\
    python3-pyfritzhome (=0.6.11) \
"

ALLOW_EMPTY:${PN}-frontend = "1"
RDEPENDS:${PN}-frontend = "\
    python3-home-assistant-frontend (=20240501.1) \
"

ALLOW_EMPTY:${PN}-google-translate = "1"
RDEPENDS:${PN}-google-translate = "\
    python3-gtts (=2.2.4) \
"

ALLOW_EMPTY:${PN}-hacs = "1"
RDEPENDS:${PN}-hacs = "\
    python3-aiogithubapi (=22.10.1) \
"

ALLOW_EMPTY:${PN}-hardware = "1"
RDEPENDS:${PN}-hardware = "\
    python3-psutil-home-assistant (=0.0.1) \
"

ALLOW_EMPTY:${PN}-hue = "1"
RDEPENDS:${PN}-hue = "\
    python3-aiohue (>=4.7.1) \
"

ALLOW_EMPTY:${PN}-image-upload = "1"
RDEPENDS:${PN}-image-upload = "\
    python3-pillow (>=10.2.0) \
"

ALLOW_EMPTY:${PN}-ipp = "1"
RDEPENDS:${PN}-ipp = "\
    python3-pyipp (=0.15.0) \
"

ALLOW_EMPTY:${PN}-keyboard-remote = "1"
RDEPENDS:${PN}-keyboard-remote = "\
    python3-evdev (>=1.6.1) \
    python3-asyncinotify (>=4.0.2) \
"

ALLOW_EMPTY:${PN}-matter = "1"
RDEPENDS:${PN}-matter = "\
    python3-python-matter-server (=5.10.0) \
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
    python3-pymodbus (>=3.6.6) \
"

ALLOW_EMPTY:${PN}-octoprint = "1"
RDEPENDS:${PN}-octoprint = "\
    python3-pyoctoprintapi (=0.1.12) \
"

ALLOW_EMPTY:${PN}-otp = "1"
RDEPENDS:${PN}-otp = "\
    python3-pyotp (=2.8.0) \
"

ALLOW_EMPTY:${PN}-pulseaudio-loopback = "1"
RDEPENDS:${PN}-pulseaudio-loopback = "\
    python3-pulsectl (>=23.5.2) \
"

ALLOW_EMPTY:${PN}-radio-browser = "1"
RDEPENDS:${PN}-radio-browser = "\
    python3-radios (=0.3.1) \
"

ALLOW_EMPTY:${PN}-recorder = "1"
RDEPENDS:${PN}-recorder = "\
    python3-sqlite3 \
    python3-fnv-hash-fast (=0.5.0) \
    python3-sqlalchemy (>=2.0.29) \
    python3-psutil-home-assistant (=0.0.1) \
"

ALLOW_EMPTY:${PN}-route53 = "1"
RDEPENDS:${PN}-route53 = "\
    python3-boto3 (>=1.34.51) \
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

ALLOW_EMPTY:${PN}-shelly = "1"
RDEPENDS:${PN}-shelly = "\
    python3-aioshelly (=9.0.0) \
"

ALLOW_EMPTY:${PN}-ssdp = "1"
RDEPENDS:${PN}-ssdp = "\
    python3-async-upnp-client (=0.38.3) \
"

ALLOW_EMPTY:${PN}-stream = "1"
RDEPENDS:${PN}-stream = "\
    python3-pyturbojpeg (=1.7.1) \
    python3-ha-av (=10.1.1) \
    python3-numpy (>=1.26.0) \
"

ALLOW_EMPTY:${PN}-systemmonitor = "1"
RDEPENDS:${PN}-systemmonitor = "\
    python3-psutil (>=5.9.8) \
    python3-psutil-home-assistant (=0.0.1) \
"

ALLOW_EMPTY:${PN}-tts = "1"
RDEPENDS:${PN}-tts = "\
    python3-mutagen (=1.47.0) \
"

ALLOW_EMPTY:${PN}-upnp = "1"
RDEPENDS:${PN}-upnp = "\
    python3-async-upnp-client (=0.38.3) \
    python3-getmac (=0.9.4) \
"

ALLOW_EMPTY:${PN}-usb = "1"
RDEPENDS:${PN}-usb = "\
    python3-pyserial (=3.5) \
    python3-pyudev (>=0.23.2) \
"

ALLOW_EMPTY:${PN}-vlc = "1"
RDEPENDS:${PN}-vlc = "\
    python3-python-vlc (>=3.0.18122) \
"

ALLOW_EMPTY:${PN}-zeroconf = "1"
RDEPENDS:${PN}-zeroconf = "\
    python3-zeroconf (>=0.132.2) \
"

RDEPENDS:${PN} += "\
    ${PN}-assist-pipeline \
    ${PN}-bluetooth \
    ${PN}-cloud \
    ${PN}-conversation \
    ${PN}-dhcp \
    ${PN}-ffmpeg \
    ${PN}-file-upload \
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
    ${PN}-amazon-polly \
    ${PN}-axis \
    ${PN}-backup \
    ${PN}-cast \
    ${PN}-debugpy \
    ${PN}-fritz \
    ${PN}-fritzbox \
    ${PN}-hacs \
    ${PN}-hue \
    ${PN}-ipp \
    ${PN}-keyboard-remote \
    ${PN}-met \
    ${PN}-modbus \
    ${PN}-octoprint \
    ${PN}-otp \
    ${PN}-pulseaudio-loopback \
    ${PN}-route53 \
    ${PN}-scrape \
    ${PN}-sentry \
    ${PN}-shelly \
    ${PN}-ssdp \
    ${PN}-systemmonitor \
    ${PN}-tts \
    ${PN}-upnp \
    ${PN}-vlc \
"