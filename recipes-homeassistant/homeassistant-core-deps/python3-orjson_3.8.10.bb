SUMMARY = "Fast, correct Python JSON library supporting dataclasses, datetimes, and numpy"
HOMEPAGE = "https://pypi.org/project/orjson/"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=1836efb2eb779966696f473ee8540542"

DEPENDS += "python3-maturin-native"

PYPI_PACKAGE = "orjson"

SRC_URI[sha256sum] = "dcf6adb4471b69875034afab51a14b64f1026bc968175a2bb02c5f6b358bd413"
SRC_URI += "crate://crates.io/ahash/0.8.3 \
           crate://crates.io/arrayvec/0.7.2 \
           crate://crates.io/associative-cache/1.0.1 \
           crate://crates.io/autocfg/1.1.0 \
           crate://crates.io/beef/0.5.2 \
           crate://crates.io/bytecount/0.6.3 \
           crate://crates.io/castaway/0.2.2 \
           crate://crates.io/cc/1.0.79 \
           crate://crates.io/cfg-if/1.0.0 \
           crate://crates.io/chrono/0.4.24 \
           crate://crates.io/compact_str/0.7.0 \
           crate://crates.io/encoding_rs/0.8.32 \
           crate://crates.io/itoa/1.0.6 \
           crate://crates.io/itoap/1.0.1 \
           crate://crates.io/libc/0.2.141 \
           crate://crates.io/libm/0.1.4 \
           crate://crates.io/num-integer/0.1.45 \
           crate://crates.io/num-traits/0.2.15 \
           crate://crates.io/once_cell/1.17.1 \
           crate://crates.io/packed_simd_2/0.3.8 \
           crate://crates.io/pyo3-build-config/0.18.2 \
           crate://crates.io/pyo3-ffi/0.18.1 \
           crate://crates.io/rustversion/1.0.12 \
           crate://crates.io/ryu/1.0.13 \
           crate://crates.io/serde/1.0.159 \
           crate://crates.io/serde_json/1.0.95 \
           crate://crates.io/simdutf8/0.1.4 \
           crate://crates.io/smallvec/1.10.0 \
           crate://crates.io/static_assertions/1.1.0 \
           crate://crates.io/target-lexicon/0.12.6 \
           crate://crates.io/version_check/0.9.4 \
           file://0001-Fix-compilation-error-for-orjson.patch \
           "

SRC_URI[ahash-0.8.3.sha256sum] = "2c99f64d1e06488f620f932677e24bc6e2897582980441ae90a671415bd7ec2f"
SRC_URI[arrayvec-0.7.2.sha256sum] = "8da52d66c7071e2e3fa2a1e5c6d088fec47b593032b254f5e980de8ea54454d6"
SRC_URI[associative-cache-1.0.1.sha256sum] = "46016233fc1bb55c23b856fe556b7db6ccd05119a0a392e04f0b3b7c79058f16"
SRC_URI[autocfg-1.1.0.sha256sum] = "d468802bab17cbc0cc575e9b053f41e72aa36bfa6b7f55e3529ffa43161b97fa"
SRC_URI[beef-0.5.2.sha256sum] = "3a8241f3ebb85c056b509d4327ad0358fbbba6ffb340bf388f26350aeda225b1"
SRC_URI[bytecount-0.6.3.sha256sum] = "2c676a478f63e9fa2dd5368a42f28bba0d6c560b775f38583c8bbaa7fcd67c9c"
SRC_URI[castaway-0.2.2.sha256sum] = "8a17ed5635fc8536268e5d4de1e22e81ac34419e5f052d4d51f4e01dcc263fcc"
SRC_URI[cc-1.0.79.sha256sum] = "50d30906286121d95be3d479533b458f87493b30a4b5f79a607db8f5d11aa91f"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[chrono-0.4.24.sha256sum] = "4e3c5919066adf22df73762e50cffcde3a758f2a848b113b586d1f86728b673b"
SRC_URI[compact_str-0.7.0.sha256sum] = "bff0805f79ecb1b35163f3957a6934ea8d04fcd36ef98b52e7316f63e72e73d1"
SRC_URI[encoding_rs-0.8.32.sha256sum] = "071a31f4ee85403370b58aca746f01041ede6f0da2730960ad001edc2b71b394"
SRC_URI[itoa-1.0.6.sha256sum] = "453ad9f582a441959e5f0d088b02ce04cfe8d51a8eaf077f12ac6d3e94164ca6"
SRC_URI[itoap-1.0.1.sha256sum] = "9028f49264629065d057f340a86acb84867925865f73bbf8d47b4d149a7e88b8"
SRC_URI[libc-0.2.141.sha256sum] = "3304a64d199bb964be99741b7a14d26972741915b3649639149b2479bb46f4b5"
SRC_URI[libm-0.1.4.sha256sum] = "7fc7aa29613bd6a620df431842069224d8bc9011086b1db4c0e0cd47fa03ec9a"
SRC_URI[num-integer-0.1.45.sha256sum] = "225d3389fb3509a24c93f5c29eb6bde2586b98d9f016636dff58d7c6f7569cd9"
SRC_URI[num-traits-0.2.15.sha256sum] = "578ede34cf02f8924ab9447f50c28075b4d3e5b269972345e7e0372b38c6cdcd"
SRC_URI[once_cell-1.17.1.sha256sum] = "b7e5500299e16ebb147ae15a00a942af264cf3688f47923b8fc2cd5858f23ad3"
SRC_URI[packed_simd_2-0.3.8.sha256sum] = "a1914cd452d8fccd6f9db48147b29fd4ae05bea9dc5d9ad578509f72415de282"
SRC_URI[pyo3-build-config-0.18.2.sha256sum] = "98a42e7f42e917ce6664c832d5eee481ad514c98250c49e0b03b20593e2c7ed0"
SRC_URI[pyo3-ffi-0.18.1.sha256sum] = "839526a5c07a17ff44823679b68add4a58004de00512a95b6c1c98a6dcac0ee5"
SRC_URI[rustversion-1.0.12.sha256sum] = "4f3208ce4d8448b3f3e7d168a73f5e0c43a61e32930de3bceeccedb388b6bf06"
SRC_URI[ryu-1.0.13.sha256sum] = "f91339c0467de62360649f8d3e185ca8de4224ff281f66000de5eb2a77a79041"
SRC_URI[serde-1.0.159.sha256sum] = "3c04e8343c3daeec41f58990b9d77068df31209f2af111e059e9fe9646693065"
SRC_URI[serde_json-1.0.95.sha256sum] = "d721eca97ac802aa7777b701877c8004d950fc142651367300d21c1cc0194744"
SRC_URI[simdutf8-0.1.4.sha256sum] = "f27f6278552951f1f2b8cf9da965d10969b2efdea95a6ec47987ab46edfe263a"
SRC_URI[smallvec-1.10.0.sha256sum] = "a507befe795404456341dfab10cef66ead4c041f62b8b11bbb92bffe5d0953e0"
SRC_URI[static_assertions-1.1.0.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[target-lexicon-0.12.6.sha256sum] = "8ae9980cab1db3fceee2f6c6f643d5d8de2997c58ee8d25fb0cc8a9e9e7348e5"
SRC_URI[version_check-0.9.4.sha256sum] = "49874b5167b65d7193b8aba1567f5c7d93d001cafc34600cee003eda787e483f"

DEPENDS += "python3-setuptools-rust-native"

inherit cargo pypi python_pyo3 python_setuptools_build_meta

do_configure() {
    python_pyo3_do_configure
    cargo_common_do_configure
}
