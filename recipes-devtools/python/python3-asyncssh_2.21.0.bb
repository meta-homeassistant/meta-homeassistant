SUMMARY = "AsyncSSH: Asynchronous SSHv2 client and server library"
HOMEPAGE = "http://asyncssh.timeheart.net"
LICENSE = "EPL-2.0 & GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=a3d68919d4bc3d853512d45cbd1cc345 \
                    file://LICENSE;md5=d9fc0efef5228704e7f5b37f27192723"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "450fe13bb8d86a8f4e7d7b5fafce7791181ca3e7c92e15bbc45dfb25866e48b3"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "asyncssh"
RDEPENDS:${PN} = "python3-cryptography python3-typing-extensions"
