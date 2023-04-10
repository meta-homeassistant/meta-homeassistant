SUMMARY = "Build and publish crates with pyo3, rust-cpython and cffi bindings as well as rust binaries as python packages"
HOMEPAGE = "https://github.com/PyO3/maturin"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "\
    file://license-apache;md5=1836efb2eb779966696f473ee8540542 \
    file://license-mit;md5=85fd3b67069cff784d98ebfc7d5c0797 \
"

SRC_URI[anyhow.sha256sum] = "224afbd727c3d6e4b90103ece64b8d1b67fbb1973b1046c2281eed3f3803f800"
SRC_URI[base64.sha256sum] = "9e1b586273c5702936fe7b7d6896644d8be71e6314cfe09d3167c95f712589e8"
SRC_URI[bitflags.sha256sum] = "bef38d45163c2f1dde094a7dfd33ccf595c92905c8f8f4fdc18d06fb1037718a"
SRC_URI[bytesize.sha256sum] = "38fcc2979eff34a4b84e1cf9a1e3da42a7d44b3b690a40cdcb23e3d556cfb2e5"
SRC_URI[camino.sha256sum] = "6031a462f977dd38968b6f23378356512feeace69cef817e1a4475108093cec3"
SRC_URI[cargo-options.sha256sum] = "860cd643171bc868500aff16c2405559b42fc71bd3130d761c2847b3e9e71cdc"
SRC_URI[cargo-platform.sha256sum] = "cbdb825da8a5df079a43676dbe042702f1707b1109f713a01420fbb4cc71fa27"
SRC_URI[cargo-xwin.sha256sum] = "f574a8d2827f03d03829efb03607297ab3cfd82583f1a1e6d9ec211ee4741433"
SRC_URI[cargo-zigbuild.sha256sum] = "b56c289fa331582c3637f30a066fdd442fa7e7388541d97e76bc9a15d5688096"
SRC_URI[cargo_metadata.sha256sum] = "08a1ec454bc3eead8719cb56e15dbbfecdbc14e4b3a3ae4936cc6e31f5fc0d07"
SRC_URI[cbindgen.sha256sum] = "a6358dedf60f4d9b8db43ad187391afe959746101346fe51bb978126bec61dfb"
SRC_URI[cc.sha256sum] = "50d30906286121d95be3d479533b458f87493b30a4b5f79a607db8f5d11aa91f"
SRC_URI[clap.sha256sum] = "a7db700bc935f9e43e88d00b0850dae18a63773cfbec6d8e070fccf7fef89a39"
SRC_URI[clap_complete_command.sha256sum] = "4160b4a4f72ef58bd766bad27c09e6ef1cc9d82a22f6a0f55d152985a4a48e31"
SRC_URI[clap_derive.sha256sum] = "0177313f9f02afc995627906bbd8967e2be069f5261954222dac78290c2b9014"
SRC_URI[clap_lex.sha256sum] = "0d4198f73e42b4936b35b5bb248d81d2b595ecb170da0bac7655c54eedfa8da8"
SRC_URI[configparser.sha256sum] = "5458d9d1a587efaf5091602c59d299696a3877a439c8f6d461a2d3cce11df87a"
SRC_URI[console.sha256sum] = "c3d79fbe8970a77e3e34151cc13d3b3e248aa0faaecb9f6091fa07ebefe5ad60"
SRC_URI[dialoguer.sha256sum] = "af3c796f3b0b408d9fd581611b47fa850821fcb84aa640b83a3c1a5be2d691f2"
SRC_URI[dirs.sha256sum] = "ca3aa72a6f96ea37bbc5aa912f6788242832f75369bdfdadcb0e38423f100059"
SRC_URI[dunce.sha256sum] = "0bd4b30a6560bbd9b4620f4de34c3f14f60848e58a9b7216801afcb4c7b31c3c"
SRC_URI[fat-macho.sha256sum] = "67f07131a2b944c2b42b6a58104600ef049c11df5454478d2b44ff5dfe58d149"
SRC_URI[flate2.sha256sum] = "a8a2db397cb1c8772f31494cb8917e48cd1e64f0fa7efac59fbd741a0a8ce841"
SRC_URI[fs-err.sha256sum] = "0845fa252299212f0389d64ba26f34fa32cfe41588355f21ed507c59a0f64541"
SRC_URI[glob.sha256sum] = "d2fabcfbdc87f4758337ca535fb41a6d701b65693ce38287d856d1674551ec9b"
SRC_URI[goblin.sha256sum] = "0d6b4de4a8eb6c46a8c77e1d3be942cb9a8bf073c22374578e5ba4b08ed0ff68"
SRC_URI[heck.sha256sum] = "95505c38b4572b2d910cecb0281560f54b440a19336cbbcb27bf6ce6adc6f5a8"
SRC_URI[ignore.sha256sum] = "713f1b139373f96a2e0ce3ac931cd01ee973c3c5dd7c40c0c2efe96ad2b6751d"
SRC_URI[indexmap.sha256sum] = "1885e79c1fc4b10f0e172c475f458b7f7b93061064d98c3293e98c5ba0c8b399"
SRC_URI[indicatif.sha256sum] = "cef509aa9bc73864d6756f0d34d35504af3cf0844373afe9b8669a5b8005a729"
SRC_URI[indoc.sha256sum] = "6fe2b9d82064e8a0226fddb3547f37f28eaa46d0fc210e275d835f08cf3b76a7"
SRC_URI[is-terminal.sha256sum] = "28dfb6c8100ccc63462345b67d1bbc3679177c75ee4bf59bf29c8b1d110b8189"
SRC_URI[itertools.sha256sum] = "b0fd2260e829bddf4cb6ea802289de2f86d6a7a690192fbe91b3f46e0f2c8473"
SRC_URI[keyring.sha256sum] = "ba264b266563c1363dcce004776cbf198d7422a4262f77f4ca285bf26ae30955"
SRC_URI[lddtree.sha256sum] = "7580a02d700ecc9e06c72b7aace6e74427a56a69310f18fdd420a5fac3832969"
SRC_URI[log.sha256sum] = "abb12e687cfb44aa40f41fc3978ef76448f9b6038cad6aef4259d3c095a2382e"
SRC_URI[minijinja.sha256sum] = "41ec399da2025bb79da141e6dcf7e5b4d73f8161ef73d3c28b99850c56620378"
SRC_URI[multipart.sha256sum] = "00dec633863867f29cb39df64a397cdf4a6354708ddd7759f70c7fb51c5f9182"
SRC_URI[native-tls.sha256sum] = "07226173c32f2926027b63cce4bcd8076c3552846cbe7925f3aaffeac0a3b92e"
SRC_URI[normpath.sha256sum] = "3a37f4eb793d70ebef49f4643fe4b8c0e60d266e3fb607158e64b6ee24b0d6d4"
SRC_URI[once_cell.sha256sum] = "b7e5500299e16ebb147ae15a00a942af264cf3688f47923b8fc2cd5858f23ad3"
SRC_URI[path-slash.sha256sum] = "1e91099d4268b0e11973f036e885d652fb0b21fedcf69738c627f94db6a44f42"
SRC_URI[pep440.sha256sum] = "8841b00ca6fabc903e8ecd496d9611db402e23f15e3d19b0b587e2ca653abd89"
SRC_URI[platform-info.sha256sum] = "4e7c23cfae725ae06d9e43010153fa77bdfa8c827bf08fe4beeb2a3514e6be12"
SRC_URI[pretty_assertions.sha256sum] = "a25e9bcb20aa780fd0bb16b72403a9064d6b3f22f026946029acb941a50af755"
SRC_URI[proc-macro2.sha256sum] = "5d727cae5b39d21da60fa540906919ad737832fe0b1c165da3a34d6548c849d6"
SRC_URI[pyproject-toml.sha256sum] = "380405edf78a88a5789f6f19ec9b76de091b5dce31eddb7a43a7386814aaa8fb"
SRC_URI[python-pkginfo.sha256sum] = "0b8cf2d8981a1c967eebacac69c68a54d9786c1b84b813841d0aab2994705608"
SRC_URI[quote.sha256sum] = "8856d8364d252a14d474036ea1358d63c9e6965c8e5c1885c18f73d70bff9c7b"
SRC_URI[regex.sha256sum] = "48aaa5748ba571fb95cd2c85c09f629215d3a6ece942baa100950af03a34f733"
SRC_URI[rpassword.sha256sum] = "6678cf63ab3491898c0d021b493c94c9b221d91295294a2a5746eacbe5928322"
SRC_URI[rustc_version.sha256sum] = "bfa0f585226d2e68097d4f95d113b15b83a82e819ab25717ec0590d9584ef366"
SRC_URI[rustversion.sha256sum] = "5583e89e108996506031660fe09baa5011b9dd0341b89029313006d1fb508d70"
SRC_URI[semver.sha256sum] = "58bc9567378fc7690d6b2addae4e60ac2eeea07becb2c64b9f218b53865cba2a"
SRC_URI[serde.sha256sum] = "bb7d1f0d3021d347a83e556fc4683dea2ea09d87bccdf88ff5c12545d89d5efb"
SRC_URI[serde_json.sha256sum] = "cad406b69c91885b5107daf2c29572f6c8cdb3c66826821e286c533490c0bc76"
SRC_URI[sha2.sha256sum] = "82e6b795fe2e3b1e845bafcb27aa35405c4d47cdfc92af5fc8d3002f76cebdc0"
SRC_URI[sha256sum] = "57ddb61e394a2df623e89d013abc939f22c18cd5de64844f4fb11da2947ac3fe"
SRC_URI[strsim.sha256sum] = "73473c0e59e6d5812c5dfe2a064a6444949f089e20eec9a2e5506596494e4623"
SRC_URI[syn.sha256sum] = "72b64191b275b66ffe2469e8af2c1cfe3bafa67b529ead792a6d0160888b4237"
SRC_URI[tar.sha256sum] = "4b55807c0344e1e6c04d7c965f5289c39a8d94ae23ed5c0b57aabac549f871c6"
SRC_URI[target-lexicon.sha256sum] = "8ae9980cab1db3fceee2f6c6f643d5d8de2997c58ee8d25fb0cc8a9e9e7348e5"
SRC_URI[tempfile.sha256sum] = "af18f7ae1acd354b992402e9ec5864359d693cd8a79dcbef59f76891701c1e95"
SRC_URI[termcolor.sha256sum] = "be55cf8942feac5c765c2c993422806843c9a9a45d4d5c407ad6dd2ea95eb9b6"
SRC_URI[terminal_size.sha256sum] = "cb20089a8ba2b69debd491f8d2d023761cbf196e999218c591fa1e7e15a21907"
SRC_URI[textwrap.sha256sum] = "222a222a5bfe1bba4a77b45ec488a741b3cb8872e5e499451fd7d0129c9c7c3d"
SRC_URI[thiserror.sha256sum] = "6a9cd18aa97d5c45c6603caea1da6628790b37f7a34b6ca89522331c5180fed0"
SRC_URI[time.sha256sum] = "a561bf4617eebd33bca6434b988f39ed798e527f51a1e797d0ee4f61c0a38376"
SRC_URI[toml.sha256sum] = "f4f7f0dd8d50a853a531c426359045b1998f04219d88799810762cd4ad314234"
SRC_URI[toml_edit.sha256sum] = "a34cc558345efd7e88b9eda9626df2138b80bb46a7606f695e751c892bc7dac6"
SRC_URI[tracing-subscriber.sha256sum] = "a6176eae26dd70d0c919749377897b54a9276bd7061339665dd68777926b5a70"
SRC_URI[tracing.sha256sum] = "8ce8c33a8d48bd45d624a6e523445fd21ec13d3653cd51f681abf67418f54eb8"
SRC_URI[trycmd.sha256sum] = "01662d21325d18cd4acae7e1dc9f29a2a88b7fbb7f9bc427c4a692aaec5773ac"
SRC_URI[uniffi_bindgen.sha256sum] = "19d84dea610e893f4043354c71e4361386475365e6e2834aded4c8cebf940311"
SRC_URI[ureq.sha256sum] = "338b31dd1314f68f3aabf3ed57ab922df95ffcd902476ca7ba3c4ce7b908c46d"
SRC_URI[which.sha256sum] = "2441c784c52b289a054b7201fc93253e288f094e2f4be9058343127c4226a269"
SRC_URI[xwin.sha256sum] = "5c53c43cb1b0385c4e1482f160cd72e4e43b8a9f436a42e3f539480c52056492"
SRC_URI[zip.sha256sum] = "0445d0fbc924bb93539b4316c11afb121ea39296f99a3c4c9edad09e3658cdef"
SRC_URI[clap_complete.sha256sum] = "10861370d2ba66b0f5989f83ebf35db6421713fd92351790e7fdd6c36774c56b"
SRC_URI[clap_complete_fig.sha256sum] = "46b30e010e669cd021e5004f3be26cff6b7c08d2a8a0d65b48d43a8cc0efd6c3"
SRC_URI[lazy_static.sha256sum] = "e2abad23fbc42b3700f2f279844dc832adb2b2eb069b2df918f455c4e18cc646"
SRC_URI[libc.sha256sum] = "201de327520df007757c1f0adce6e827fe8562fbc28bfd9c15571c66ca1f5f79"
SRC_URI[unicode-width.sha256sum] = "c0edd1e5b14653f783770bce4a4dabb4a5108a5370a5f5d8cfe8710c361f6c8b"
SRC_URI[encode_unicode.sha256sum] = "a357d28ed41a50f9c765dbfe56cbc04a64e53e5fc58ba79fbc34c10ef3df831f"
SRC_URI[windows-sys.sha256sum] = "ea04155a16a59f9eab786fe12a4a450e75cdb175f9e0d80da1e17db09f55b8d2"

SRC_URI:append = " \
    crate://crates.io/anyhow/1.0.69 \
    crate://crates.io/base64/0.13.1 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/bytesize/1.2.0 \
    crate://crates.io/camino/1.1.3 \
    crate://crates.io/cargo-options/0.5.3 \
    crate://crates.io/cargo-platform/0.1.2 \
    crate://crates.io/cargo-xwin/0.13.3 \
    crate://crates.io/cargo-zigbuild/0.14.3 \
    crate://crates.io/cargo_metadata/0.15.3 \
    crate://crates.io/cbindgen/0.24.3 \
    crate://crates.io/cc/1.0.79 \
    crate://crates.io/clap/4.0.32 \
    crate://crates.io/clap_complete/4.0.7 \
    crate://crates.io/clap_complete_command/0.4.0 \
    crate://crates.io/clap_complete_fig/4.0.2 \
    crate://crates.io/clap_derive/4.0.21 \
    crate://crates.io/clap_lex/0.3.0 \
    crate://crates.io/configparser/3.0.2 \
    crate://crates.io/console/0.15.5 \
    crate://crates.io/dialoguer/0.10.3 \
    crate://crates.io/dirs/4.0.0 \
    crate://crates.io/dunce/1.0.3 \
    crate://crates.io/encode_unicode/0.3.6 \
    crate://crates.io/fat-macho/0.4.6 \
    crate://crates.io/flate2/1.0.25 \
    crate://crates.io/fs-err/2.9.0 \
    crate://crates.io/glob/0.3.1 \
    crate://crates.io/goblin/0.6.1 \
    crate://crates.io/heck/0.4.1 \
    crate://crates.io/ignore/0.4.18 \
    crate://crates.io/indexmap/1.9.2 \
    crate://crates.io/indicatif/0.17.3 \
    crate://crates.io/indoc/2.0.0 \
    crate://crates.io/is-terminal/0.4.2 \
    crate://crates.io/itertools/0.10.5 \
    crate://crates.io/keyring/1.2.1 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/lddtree/0.3.2 \
    crate://crates.io/libc/0.2.139 \
    crate://crates.io/log/0.4.17 \
    crate://crates.io/minijinja/0.30.5 \
    crate://crates.io/multipart/0.18.0 \
    crate://crates.io/native-tls/0.2.11 \
    crate://crates.io/normpath/1.0.1 \
    crate://crates.io/once_cell/1.17.1 \
    crate://crates.io/path-slash/0.2.1 \
    crate://crates.io/pep440/0.2.0 \
    crate://crates.io/platform-info/1.0.2 \
    crate://crates.io/pretty_assertions/1.3.0 \
    crate://crates.io/proc-macro2/1.0.51 \
    crate://crates.io/pyproject-toml/0.3.1 \
    crate://crates.io/python-pkginfo/0.5.5 \
    crate://crates.io/quote/1.0.23 \
    crate://crates.io/regex/1.7.1 \
    crate://crates.io/rpassword/7.2.0 \
    crate://crates.io/rustc_version/0.4.0 \
    crate://crates.io/rustversion/1.0.11 \
    crate://crates.io/semver/1.0.16 \
    crate://crates.io/serde/1.0.152 \
    crate://crates.io/serde_json/1.0.93 \
    crate://crates.io/sha2/0.10.6 \
    crate://crates.io/strsim/0.10.0 \
    crate://crates.io/syn/1.0.109 \
    crate://crates.io/tar/0.4.38 \
    crate://crates.io/target-lexicon/0.12.6 \
    crate://crates.io/tempfile/3.4.0 \
    crate://crates.io/termcolor/1.2.0 \
    crate://crates.io/terminal_size/0.2.3 \
    crate://crates.io/textwrap/0.16.0 \
    crate://crates.io/thiserror/1.0.38 \
    crate://crates.io/time/0.3.17 \
    crate://crates.io/toml/0.5.11 \
    crate://crates.io/toml_edit/0.17.1 \
    crate://crates.io/tracing-subscriber/0.3.16 \
    crate://crates.io/tracing/0.1.37 \
    crate://crates.io/trycmd/0.14.10 \
    crate://crates.io/unicode-width/0.1.10 \
    crate://crates.io/uniffi_bindgen/0.22.0 \
    crate://crates.io/ureq/2.6.2 \
    crate://crates.io/which/4.4.0 \
    crate://crates.io/windows-sys/0.36.1 \
    crate://crates.io/xwin/0.2.10 \
    crate://crates.io/zip/0.6.4 \
"

inherit pypi cargo native
