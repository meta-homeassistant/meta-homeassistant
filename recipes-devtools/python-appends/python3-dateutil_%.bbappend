# dateutil 4.0 imports zoneinfo (dateutil/tz/_tzpath.py), which the
# meta-python recipe does not depend on, so "import dateutil.tz" fails
# (blinkpy, gql). Drop once meta-python has the fix.
RDEPENDS:${PN} += "python3-zoneinfo"
