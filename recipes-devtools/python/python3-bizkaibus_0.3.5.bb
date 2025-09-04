SUMMARY = "Online information for buses of Biscay bus services (Basque Country, Spain)."
HOMEPAGE = "https://github.com/UgaitzEtxebarria/BizkaibusRTPI"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9c2ab2a1e863d750bf4e808eb68cc7d8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7b5dd4a34019fd642984e3231134fa4885b01593be24a422bab037bc084d9857"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = " \
	python3-aiohttp \
"

PYPI_PACKAGE = "bizkaibus"
