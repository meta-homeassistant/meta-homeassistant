SUMMARY = "A tool for signing Python package distributions"
HOMEPAGE = "https://github.com/sigstore/sigstore-python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[sha256sum] = "1252c34b6bf0f5c0680dffe36e1961bd23da9dd77838fc8ece35bcf87a3bf6df"

inherit pypi python_flit_core

PYPI_PACKAGE = "sigstore"

RDEPENDS:${PN} = "\
    python3-appdirs (>=1.4) \
    python3-cryptography (>=39) \
    python3-id (>=1.0.0) \
    python3-pydantic (=1.10.7) \
    python3-pyjwt (>=2.1) \
    python3-pyopenssl (>=23.0.0) \
    python3-requests \
    python3-securesystemslib \
    python3-sigstore-protobuf-specs (>=0.1.0) \
    python3-tuf (>=2.1) \
"
