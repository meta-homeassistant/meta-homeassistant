DESCRIPTION = "Rule-based number formatting using Unicode CLDR data"
HOMEPAGE = "https://github.com/rhasspy/unicode-rbnf"
LICENSE = "MIT"

inherit python3-whl

# We need to reimplement these since there is a - versus _ problem in the package name
WHL_BPN="unicode_rbnf"
WHL_BP="unicode_rbnf-1.0.0"
WHL_PN="unicode_rbnf"

LIC_FILES_CHKSUM = "file://${WHL_BP}.dist-info/LICENSE.md;md5=2aa2bed6f8750823223a2c11d7bc90c5"

SRC_URI = "https://files.pythonhosted.org/packages/36/8c/b7cabfc1083f683770d38aa206b3c06eae807f6e1101c7fbfb68e90c8da9/${WHL_BP}-py3-none-any.whl;downloadfilename=${BP}.zip;subdir=${BP}"
SRC_URI[sha256sum] = "81e4fb66f50c8aa590b555505834405dc61d6230052f6d44a59e820392dd3758"