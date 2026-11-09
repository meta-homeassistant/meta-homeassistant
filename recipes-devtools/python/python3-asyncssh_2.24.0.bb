SUMMARY = "AsyncSSH: Asynchronous SSHv2 client and server library"
HOMEPAGE = "http://asyncssh.timeheart.net"
LICENSE = "EPL-2.0 AND GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=a3d68919d4bc3d853512d45cbd1cc345 \
                    file://LICENSE;md5=d9fc0efef5228704e7f5b37f27192723"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4064c590e59ce2e8d82a2f66d35f3120d765828b4df5e3dbfb07b4a8c24686c9"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "python3-cryptography python3-typing-extensions"
