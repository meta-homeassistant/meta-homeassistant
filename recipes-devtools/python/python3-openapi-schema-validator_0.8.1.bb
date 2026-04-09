SUMMARY = "OpenAPI schema validation for Python"
HOMEPAGE = "https://github.com/python-openapi/openapi-schema-validator"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7953a47eea38d245978aa5729836ea8f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4c57266ce8cbfa37bb4eb4d62cdb7d19356c3a468e3535743c4562863e1790da"

inherit pypi python_poetry_core ptest-python-pytest

PYPI_PACKAGE = "openapi_schema_validator"
RDEPENDS:${PN} = "\
    python3-jsonschema (>=4.19.1) \
    python3-rfc3339-validator \
    python3-referencing \
    python3-pydantic (>=2.0.0) \
    python3-pydantic-settings (>=2.0.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-cov \
    python3-deptry \
"
