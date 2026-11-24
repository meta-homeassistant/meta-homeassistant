# boto3 imports s3transfer and jmespath unconditionally (boto3/compat.py, which
# boto3/__init__.py loads, and boto3/resources/response.py). The
# meta-virtualization recipe, which wins over the older
# meta-python-ai one, does not list them, so "import boto3" fails at runtime
# (hass-nabucasa, through pycognito).
RDEPENDS:${PN} += "python3-jmespath python3-s3transfer"
