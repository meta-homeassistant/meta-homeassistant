SUMMARY = "Python library and CLI tool to interface with Google Translate's text-to-speech API"
HOMEPAGE = "https://github.com/pndurette/gTTS"
LICENSE = "MIT"

inherit python3-whl

WHL_BPN="gtts"
WHL_BP="gTTS-2.2.4"
WHL_PN="gTTS"

LIC_FILES_CHKSUM = "file://${WHL_BP}.dist-info/LICENSE;md5=9adeade917617bdadfcd128d5647b498"

SRC_URI = "https://files.pythonhosted.org/packages/4d/5e/a658e997640281736e39f0f1767e662dcda4547e9908fb20e92918df9f87/${WHL_BP}-py3-none-any.whl;downloadfilename=${BP}.zip;subdir=${BP}"
SRC_URI[sha256sum] = "60f6a611ea858badcceb328544b28435b663e39898859beeb9adb2a874bc1eca"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-click \
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-six \
"
