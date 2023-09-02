SUMMARY = "Fast, correct Python JSON library supporting dataclasses, datetimes, and numpy"
HOMEPAGE = "https://pypi.org/project/orjson/"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=1836efb2eb779966696f473ee8540542"

DEPENDS += "python3-maturin-native"

PYPI_PACKAGE = "orjson"

SRC_URI[sha256sum] = "db373a25ec4a4fccf8186f9a72a1b3442837e40807a736a815ab42481e83b7d0"
SRC_URI += "crate://crates.io/ahash/0.8.3 \
           crate://crates.io/android-tzdata/0.1.1 \
           crate://crates.io/arrayvec/0.7.2 \
           crate://crates.io/associative-cache/1.0.1 \
           crate://crates.io/autocfg/1.1.0 \
           crate://crates.io/beef/0.5.2 \
           crate://crates.io/bytecount/0.6.3 \
           crate://crates.io/castaway/0.2.2 \
           crate://crates.io/cc/1.0.79 \
           crate://crates.io/cfg-if/1.0.0 \
           crate://crates.io/chrono/0.4.26 \
           crate://crates.io/compact_str/0.7.0 \
           crate://crates.io/encoding_rs/0.8.32 \
           crate://crates.io/itoa/1.0.6 \
           crate://crates.io/itoap/1.0.1 \
           crate://crates.io/libc/0.2.144 \
           crate://crates.io/libm/0.1.4 \
           crate://crates.io/num-traits/0.2.15 \
           crate://crates.io/once_cell/1.17.2 \
           crate://crates.io/packed_simd_2/0.3.8 \
           crate://crates.io/pyo3-build-config/0.19.0 \
           crate://crates.io/pyo3-ffi/0.19.0 \
           crate://crates.io/rustversion/1.0.12 \
           crate://crates.io/ryu/1.0.13 \
           crate://crates.io/serde/1.0.163 \
           crate://crates.io/serde_json/1.0.96 \
           crate://crates.io/simdutf8/0.1.4 \
           crate://crates.io/smallvec/1.10.0 \
           crate://crates.io/static_assertions/1.1.0 \
           crate://crates.io/target-lexicon/0.12.7 \
           crate://crates.io/version_check/0.9.4 \
           file://0001-Fix-compilation-error-for-orjson.patch \
           "

SRC_URI[ahash-0.8.3.sha256sum] = "2c99f64d1e06488f620f932677e24bc6e2897582980441ae90a671415bd7ec2f"
SRC_URI[android-tzdata-0.1.1.sha256sum] = "e999941b234f3131b00bc13c22d06e8c5ff726d1b6318ac7eb276997bbb4fef0"
SRC_URI[arrayvec-0.7.2.sha256sum] = "8da52d66c7071e2e3fa2a1e5c6d088fec47b593032b254f5e980de8ea54454d6"
SRC_URI[associative-cache-1.0.1.sha256sum] = "46016233fc1bb55c23b856fe556b7db6ccd05119a0a392e04f0b3b7c79058f16"
SRC_URI[autocfg-1.1.0.sha256sum] = "d468802bab17cbc0cc575e9b053f41e72aa36bfa6b7f55e3529ffa43161b97fa"
SRC_URI[beef-0.5.2.sha256sum] = "3a8241f3ebb85c056b509d4327ad0358fbbba6ffb340bf388f26350aeda225b1"
SRC_URI[bytecount-0.6.3.sha256sum] = "2c676a478f63e9fa2dd5368a42f28bba0d6c560b775f38583c8bbaa7fcd67c9c"
SRC_URI[castaway-0.2.2.sha256sum] = "8a17ed5635fc8536268e5d4de1e22e81ac34419e5f052d4d51f4e01dcc263fcc"
SRC_URI[cc-1.0.79.sha256sum] = "50d30906286121d95be3d479533b458f87493b30a4b5f79a607db8f5d11aa91f"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[chrono-0.4.26.sha256sum] = "ec837a71355b28f6556dbd569b37b3f363091c0bd4b2e735674521b4c5fd9bc5"
SRC_URI[compact_str-0.7.0.sha256sum] = "bff0805f79ecb1b35163f3957a6934ea8d04fcd36ef98b52e7316f63e72e73d1"
SRC_URI[encoding_rs-0.8.32.sha256sum] = "071a31f4ee85403370b58aca746f01041ede6f0da2730960ad001edc2b71b394"
SRC_URI[itoa-1.0.6.sha256sum] = "453ad9f582a441959e5f0d088b02ce04cfe8d51a8eaf077f12ac6d3e94164ca6"
SRC_URI[itoap-1.0.1.sha256sum] = "9028f49264629065d057f340a86acb84867925865f73bbf8d47b4d149a7e88b8"
SRC_URI[libc-0.2.144.sha256sum] = "2b00cc1c228a6782d0f076e7b232802e0c5689d41bb5df366f2a6b6621cfdfe1"
SRC_URI[libm-0.1.4.sha256sum] = "7fc7aa29613bd6a620df431842069224d8bc9011086b1db4c0e0cd47fa03ec9a"
SRC_URI[num-traits-0.2.15.sha256sum] = "578ede34cf02f8924ab9447f50c28075b4d3e5b269972345e7e0372b38c6cdcd"
SRC_URI[once_cell-1.17.2.sha256sum] = "9670a07f94779e00908f3e686eab508878ebb390ba6e604d3a284c00e8d0487b"
SRC_URI[packed_simd_2-0.3.8.sha256sum] = "a1914cd452d8fccd6f9db48147b29fd4ae05bea9dc5d9ad578509f72415de282"
SRC_URI[pyo3-build-config-0.19.0.sha256sum] = "713eccf888fb05f1a96eb78c0dbc51907fee42b3377272dc902eb38985f418d5"
SRC_URI[pyo3-ffi-0.19.0.sha256sum] = "5b2ecbdcfb01cbbf56e179ce969a048fd7305a66d4cdf3303e0da09d69afe4c3"
SRC_URI[rustversion-1.0.12.sha256sum] = "4f3208ce4d8448b3f3e7d168a73f5e0c43a61e32930de3bceeccedb388b6bf06"
SRC_URI[ryu-1.0.13.sha256sum] = "f91339c0467de62360649f8d3e185ca8de4224ff281f66000de5eb2a77a79041"
SRC_URI[serde-1.0.163.sha256sum] = "2113ab51b87a539ae008b5c6c02dc020ffa39afd2d83cffcb3f4eb2722cebec2"
SRC_URI[serde_json-1.0.96.sha256sum] = "057d394a50403bcac12672b2b18fb387ab6d289d957dab67dd201875391e52f1"
SRC_URI[simdutf8-0.1.4.sha256sum] = "f27f6278552951f1f2b8cf9da965d10969b2efdea95a6ec47987ab46edfe263a"
SRC_URI[smallvec-1.10.0.sha256sum] = "a507befe795404456341dfab10cef66ead4c041f62b8b11bbb92bffe5d0953e0"
SRC_URI[static_assertions-1.1.0.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[target-lexicon-0.12.7.sha256sum] = "fd1ba337640d60c3e96bc6f0638a939b9c9a7f2c316a1598c279828b3d1dc8c5"
SRC_URI[version_check-0.9.4.sha256sum] = "49874b5167b65d7193b8aba1567f5c7d93d001cafc34600cee003eda787e483f"

DEPENDS += "python3-setuptools-rust-native"

inherit cargo pypi python_pyo3 python_setuptools_build_meta

do_configure() {
    python_pyo3_do_configure
    cargo_common_do_configure
}
