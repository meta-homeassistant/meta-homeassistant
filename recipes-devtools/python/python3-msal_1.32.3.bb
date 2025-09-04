SUMMARY = "The Microsoft Authentication Library (MSAL) for Python library enables your app to access the Microsoft Cloud by supporting authentication of users with Microsoft Azure Active Directory accounts (AAD) and Microsoft Accounts (MSA) using industry standard OAuth2 and OpenID Connect."
HOMEPAGE = "https://github.com/AzureAD/microsoft-authentication-library-for-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bbfbc44677c93751d972e8b36751a695"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5eea038689c78a5a70ca8ecbe1245458b55a857bd096efb6989c69ba15985d35"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-pyjwt (>=1.0.0) \
    python3-cryptography (>=2.5) \
    python3-requests (>2.0.0) \
"

PYPI_PACKAGE = "msal"
