SUMMARY = "Fast, correct Python JSON library supporting dataclasses, datetimes, and numpy"
HOMEPAGE = "https://pypi.org/project/orjson/"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=1836efb2eb779966696f473ee8540542"

DEPENDS += "python3-maturin-native"

PYPI_PACKAGE = "orjson"

SRC_URI[sha256sum] = "02e693843c2959befdd82d1ebae8b05ed12d1cb821605d5f9fe9f98ca5c9fd2b"
SRC_URI += "crate://crates.io/ahash/0.8.3 \
           crate://crates.io/arrayvec/0.7.4 \
           crate://crates.io/associative-cache/2.0.0 \
           crate://crates.io/autocfg/1.1.0 \
           crate://crates.io/beef/0.5.2 \
           crate://crates.io/bytecount/0.6.4 \
           crate://crates.io/castaway/0.2.2 \
           crate://crates.io/cc/1.0.83 \
           crate://crates.io/cfg-if/1.0.0 \
           crate://crates.io/chrono/0.4.31 \
           crate://crates.io/compact_str/0.7.1 \
           crate://crates.io/encoding_rs/0.8.33 \
           crate://crates.io/itoa/1.0.9 \
           crate://crates.io/itoap/1.0.1 \
           crate://crates.io/libc/0.2.149 \
           crate://crates.io/libm/0.2.8 \
           crate://crates.io/no-panic/0.1.26 \
           crate://crates.io/num-traits/0.2.17 \
           crate://crates.io/once_cell/1.18.0 \
           crate://crates.io/packed_simd/0.3.9 \
           crate://crates.io/proc-macro2/1.0.69 \
           crate://crates.io/pyo3-build-config/0.20.0 \
           crate://crates.io/pyo3-ffi/0.20.0 \
           crate://crates.io/quote/1.0.33 \
           crate://crates.io/rustversion/1.0.14 \
           crate://crates.io/ryu/1.0.15 \
           crate://crates.io/serde/1.0.188 \
           crate://crates.io/serde_derive/1.0.188 \
           crate://crates.io/serde_json/1.0.107 \
           crate://crates.io/simdutf8/0.1.4 \
           crate://crates.io/smallvec/1.11.1 \
           crate://crates.io/static_assertions/1.1.0 \
           crate://crates.io/syn/2.0.38 \
           crate://crates.io/target-lexicon/0.12.11 \
           crate://crates.io/unicode-ident/1.0.12 \
           crate://crates.io/version_check/0.9.4 \
           file://0001-Fix-compilation-error-for-orjson.patch \
           "

SRC_URI[ahash-0.8.3.sha256sum] = "2c99f64d1e06488f620f932677e24bc6e2897582980441ae90a671415bd7ec2f"
SRC_URI[arrayvec-0.7.4.sha256sum] = "96d30a06541fbafbc7f82ed10c06164cfbd2c401138f6addd8404629c4b16711"
SRC_URI[associative-cache-2.0.0.sha256sum] = "b993cd767a2bc7307dd87622311ca22c44329cc7a21366206bfa0896827b2bad"
SRC_URI[autocfg-1.1.0.sha256sum] = "d468802bab17cbc0cc575e9b053f41e72aa36bfa6b7f55e3529ffa43161b97fa"
SRC_URI[beef-0.5.2.sha256sum] = "3a8241f3ebb85c056b509d4327ad0358fbbba6ffb340bf388f26350aeda225b1"
SRC_URI[bytecount-0.6.4.sha256sum] = "ad152d03a2c813c80bb94fedbf3a3f02b28f793e39e7c214c8a0bcc196343de7"
SRC_URI[castaway-0.2.2.sha256sum] = "8a17ed5635fc8536268e5d4de1e22e81ac34419e5f052d4d51f4e01dcc263fcc"
SRC_URI[cc-1.0.83.sha256sum] = "f1174fb0b6ec23863f8b971027804a42614e347eafb0a95bf0b12cdae21fc4d0"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[chrono-0.4.31.sha256sum] = "7f2c685bad3eb3d45a01354cedb7d5faa66194d1d58ba6e267a8de788f79db38"
SRC_URI[compact_str-0.7.1.sha256sum] = "f86b9c4c00838774a6d902ef931eff7470720c51d90c2e32cfe15dc304737b3f"
SRC_URI[encoding_rs-0.8.33.sha256sum] = "7268b386296a025e474d5140678f75d6de9493ae55a5d709eeb9dd08149945e1"
SRC_URI[itoa-1.0.9.sha256sum] = "af150ab688ff2122fcef229be89cb50dd66af9e01a4ff320cc137eecc9bacc38"
SRC_URI[itoap-1.0.1.sha256sum] = "9028f49264629065d057f340a86acb84867925865f73bbf8d47b4d149a7e88b8"
SRC_URI[libc-0.2.149.sha256sum] = "a08173bc88b7955d1b3145aa561539096c421ac8debde8cbc3612ec635fee29b"
SRC_URI[libm-0.2.8.sha256sum] = "4ec2a862134d2a7d32d7983ddcdd1c4923530833c9f2ea1a44fc5fa473989058"
SRC_URI[no-panic-0.1.26.sha256sum] = "71a6d126424f5ce0bb4587ff4561421d44aeede520541cc66f1bb912506ae46a"
SRC_URI[num-traits-0.2.17.sha256sum] = "39e3200413f237f41ab11ad6d161bc7239c84dcb631773ccd7de3dfe4b5c267c"
SRC_URI[once_cell-1.18.0.sha256sum] = "dd8b5dd2ae5ed71462c540258bedcb51965123ad7e7ccf4b9a8cafaa4a63576d"
SRC_URI[packed_simd-0.3.9.sha256sum] = "1f9f08af0c877571712e2e3e686ad79efad9657dbf0f7c3c8ba943ff6c38932d"
SRC_URI[proc-macro2-1.0.69.sha256sum] = "134c189feb4956b20f6f547d2cf727d4c0fe06722b20a0eec87ed445a97f92da"
SRC_URI[pyo3-build-config-0.20.0.sha256sum] = "a96fe70b176a89cff78f2fa7b3c930081e163d5379b4dcdf993e3ae29ca662e5"
SRC_URI[pyo3-ffi-0.20.0.sha256sum] = "214929900fd25e6604661ed9cf349727c8920d47deff196c4e28165a6ef2a96b"
SRC_URI[quote-1.0.33.sha256sum] = "5267fca4496028628a95160fc423a33e8b2e6af8a5302579e322e4b520293cae"
SRC_URI[rustversion-1.0.14.sha256sum] = "7ffc183a10b4478d04cbbbfc96d0873219d962dd5accaff2ffbd4ceb7df837f4"
SRC_URI[ryu-1.0.15.sha256sum] = "1ad4cc8da4ef723ed60bced201181d83791ad433213d8c24efffda1eec85d741"
SRC_URI[serde-1.0.188.sha256sum] = "cf9e0fcba69a370eed61bcf2b728575f726b50b55cba78064753d708ddc7549e"
SRC_URI[serde_derive-1.0.188.sha256sum] = "4eca7ac642d82aa35b60049a6eccb4be6be75e599bd2e9adb5f875a737654af2"
SRC_URI[serde_json-1.0.107.sha256sum] = "6b420ce6e3d8bd882e9b243c6eed35dbc9a6110c9769e74b584e0d68d1f20c65"
SRC_URI[simdutf8-0.1.4.sha256sum] = "f27f6278552951f1f2b8cf9da965d10969b2efdea95a6ec47987ab46edfe263a"
SRC_URI[smallvec-1.11.1.sha256sum] = "942b4a808e05215192e39f4ab80813e599068285906cc91aa64f923db842bd5a"
SRC_URI[static_assertions-1.1.0.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[syn-2.0.38.sha256sum] = "e96b79aaa137db8f61e26363a0c9b47d8b4ec75da28b7d1d614c2303e232408b"
SRC_URI[target-lexicon-0.12.11.sha256sum] = "9d0e916b1148c8e263850e1ebcbd046f333e0683c724876bb0da63ea4373dc8a"
SRC_URI[unicode-ident-1.0.12.sha256sum] = "3354b9ac3fae1ff6755cb6db53683adb661634f67557942dea4facebec0fee4b"
SRC_URI[version_check-0.9.4.sha256sum] = "49874b5167b65d7193b8aba1567f5c7d93d001cafc34600cee003eda787e483f"

DEPENDS += "python3-setuptools-rust-native"

inherit cargo pypi python_pyo3 python_setuptools_build_meta

do_configure() {
    python_pyo3_do_configure
    cargo_common_do_configure
}
