SUMMARY = "Fast, correct Python JSON library supporting dataclasses, datetimes, and numpy"
HOMEPAGE = "https://pypi.org/project/orjson/"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=1836efb2eb779966696f473ee8540542"

DEPENDS += "python3-maturin-native"

PYPI_PACKAGE = "orjson"

SRC_URI[sha256sum] = "24257c8f641979bf25ecd3e27251b5cc194cdd3a6e96004aac8446f5e63d9664"
SRC_URI += "crate://crates.io/ahash/0.8.3 \
           crate://crates.io/android-tzdata/0.1.1 \
           crate://crates.io/arrayvec/0.7.4 \
           crate://crates.io/associative-cache/1.0.1 \
           crate://crates.io/autocfg/1.1.0 \
           crate://crates.io/beef/0.5.2 \
           crate://crates.io/bytecount/0.6.3 \
           crate://crates.io/castaway/0.2.2 \
           crate://crates.io/cc/1.0.79 \
           crate://crates.io/cfg-if/1.0.0 \
           crate://crates.io/chrono/0.4.26 \
           crate://crates.io/compact_str/0.7.1 \
           crate://crates.io/encoding_rs/0.8.32 \
           crate://crates.io/itoa/1.0.8 \
           crate://crates.io/itoap/1.0.1 \
           crate://crates.io/libc/0.2.147 \
           crate://crates.io/libm/0.1.4 \
           crate://crates.io/num-traits/0.2.15 \
           crate://crates.io/once_cell/1.18.0 \
           crate://crates.io/packed_simd_2/0.3.8 \
           crate://crates.io/pyo3-build-config/0.19.1 \
           crate://crates.io/pyo3-ffi/0.19.1 \
           crate://crates.io/rustversion/1.0.13 \
           crate://crates.io/ryu/1.0.14 \
           crate://crates.io/serde/1.0.167 \
           crate://crates.io/serde_json/1.0.100 \
           crate://crates.io/simdutf8/0.1.4 \
           crate://crates.io/smallvec/1.11.0 \
           crate://crates.io/static_assertions/1.1.0 \
           crate://crates.io/target-lexicon/0.12.8 \
           crate://crates.io/version_check/0.9.4 \
           file://0001-Fix-compilation-error-for-orjson.patch \
           "

SRC_URI[ahash-0.8.3.sha256sum] = "2c99f64d1e06488f620f932677e24bc6e2897582980441ae90a671415bd7ec2f"
SRC_URI[android-tzdata-0.1.1.sha256sum] = "e999941b234f3131b00bc13c22d06e8c5ff726d1b6318ac7eb276997bbb4fef0"
SRC_URI[arrayvec-0.7.4.sha256sum] = "96d30a06541fbafbc7f82ed10c06164cfbd2c401138f6addd8404629c4b16711"
SRC_URI[associative-cache-1.0.1.sha256sum] = "46016233fc1bb55c23b856fe556b7db6ccd05119a0a392e04f0b3b7c79058f16"
SRC_URI[autocfg-1.1.0.sha256sum] = "d468802bab17cbc0cc575e9b053f41e72aa36bfa6b7f55e3529ffa43161b97fa"
SRC_URI[beef-0.5.2.sha256sum] = "3a8241f3ebb85c056b509d4327ad0358fbbba6ffb340bf388f26350aeda225b1"
SRC_URI[bytecount-0.6.3.sha256sum] = "2c676a478f63e9fa2dd5368a42f28bba0d6c560b775f38583c8bbaa7fcd67c9c"
SRC_URI[castaway-0.2.2.sha256sum] = "8a17ed5635fc8536268e5d4de1e22e81ac34419e5f052d4d51f4e01dcc263fcc"
SRC_URI[cc-1.0.79.sha256sum] = "50d30906286121d95be3d479533b458f87493b30a4b5f79a607db8f5d11aa91f"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[chrono-0.4.26.sha256sum] = "ec837a71355b28f6556dbd569b37b3f363091c0bd4b2e735674521b4c5fd9bc5"
SRC_URI[compact_str-0.7.1.sha256sum] = "f86b9c4c00838774a6d902ef931eff7470720c51d90c2e32cfe15dc304737b3f"
SRC_URI[encoding_rs-0.8.32.sha256sum] = "071a31f4ee85403370b58aca746f01041ede6f0da2730960ad001edc2b71b394"
SRC_URI[itoa-1.0.8.sha256sum] = "62b02a5381cc465bd3041d84623d0fa3b66738b52b8e2fc3bab8ad63ab032f4a"
SRC_URI[itoap-1.0.1.sha256sum] = "9028f49264629065d057f340a86acb84867925865f73bbf8d47b4d149a7e88b8"
SRC_URI[libc-0.2.147.sha256sum] = "b4668fb0ea861c1df094127ac5f1da3409a82116a4ba74fca2e58ef927159bb3"
SRC_URI[libm-0.1.4.sha256sum] = "7fc7aa29613bd6a620df431842069224d8bc9011086b1db4c0e0cd47fa03ec9a"
SRC_URI[num-traits-0.2.15.sha256sum] = "578ede34cf02f8924ab9447f50c28075b4d3e5b269972345e7e0372b38c6cdcd"
SRC_URI[once_cell-1.18.0.sha256sum] = "dd8b5dd2ae5ed71462c540258bedcb51965123ad7e7ccf4b9a8cafaa4a63576d"
SRC_URI[packed_simd_2-0.3.8.sha256sum] = "a1914cd452d8fccd6f9db48147b29fd4ae05bea9dc5d9ad578509f72415de282"
SRC_URI[pyo3-build-config-0.19.1.sha256sum] = "554db24f0b3c180a9c0b1268f91287ab3f17c162e15b54caaae5a6b3773396b0"
SRC_URI[pyo3-ffi-0.19.1.sha256sum] = "922ede8759e8600ad4da3195ae41259654b9c55da4f7eec84a0ccc7d067a70a4"
SRC_URI[rustversion-1.0.13.sha256sum] = "dc31bd9b61a32c31f9650d18add92aa83a49ba979c143eefd27fe7177b05bd5f"
SRC_URI[ryu-1.0.14.sha256sum] = "fe232bdf6be8c8de797b22184ee71118d63780ea42ac85b61d1baa6d3b782ae9"
SRC_URI[serde-1.0.167.sha256sum] = "7daf513456463b42aa1d94cff7e0c24d682b429f020b9afa4f5ba5c40a22b237"
SRC_URI[serde_json-1.0.100.sha256sum] = "0f1e14e89be7aa4c4b78bdbdc9eb5bf8517829a600ae8eaa39a6e1d960b5185c"
SRC_URI[simdutf8-0.1.4.sha256sum] = "f27f6278552951f1f2b8cf9da965d10969b2efdea95a6ec47987ab46edfe263a"
SRC_URI[smallvec-1.11.0.sha256sum] = "62bb4feee49fdd9f707ef802e22365a35de4b7b299de4763d44bfea899442ff9"
SRC_URI[static_assertions-1.1.0.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[target-lexicon-0.12.8.sha256sum] = "1b1c7f239eb94671427157bd93b3694320f3668d4e1eff08c7285366fd777fac"
SRC_URI[version_check-0.9.4.sha256sum] = "49874b5167b65d7193b8aba1567f5c7d93d001cafc34600cee003eda787e483f"

DEPENDS += "python3-setuptools-rust-native"

inherit cargo pypi python_pyo3 python_setuptools_build_meta

do_configure() {
    python_pyo3_do_configure
    cargo_common_do_configure
}
