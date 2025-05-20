SUMMARY = "Google Spreadsheets Python API"
HOMEPAGE = "https://github.com/burnash/gspread"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=745480c87294e3af5c08783493eb23c8"

SRC_URI[sha256sum] = "8620e987e5340315f2b8d8d26cf97e4736a84b3325a17c7d9bcff70525dc3003"

RDEPENDS:${PN} = "\
    python3-google-auth \
    python3-google-auth-oauthlib \
    python3-strenum \
"

inherit pypi setuptools3
