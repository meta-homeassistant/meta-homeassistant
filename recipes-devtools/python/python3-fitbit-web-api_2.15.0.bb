SUMMARY = "Fitbit Web API"
HOMEPAGE = "https://github.com/allenporter/fitbit-web-api"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fadb4c1a30a15a1ee80a4dafcd77b3e0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "2339480d3665398a56eb335e317b2471b2680ad1311d14a739e956338f73a717"

inherit pypi python_hatchling

RDEPENDS:${PN} = "\
    python3-dateutil \
    python3-urllib3 \
    python3-aiohttp \
    python3-pydantic \
    python3-aiohttp-retry \
"