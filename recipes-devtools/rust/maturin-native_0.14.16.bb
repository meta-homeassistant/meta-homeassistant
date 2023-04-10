SUMMARY = "Build and publish crates with pyo3, rust-cpython and cffi bindings as well as rust binaries as python packages"
HOMEPAGE = "https://github.com/PyO3/maturin"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "\
    file://license-apache;md5=1836efb2eb779966696f473ee8540542 \
    file://license-mit;md5=85fd3b67069cff784d98ebfc7d5c0797 \
"

SRC_URI[adler.sha256sum] = "f26201604c87b1e01bd3d98f8d5d9a8fcbb815e8cedb41ffccbeb4bf593a35fe"
SRC_URI[aes.sha256sum] = "9e8b47f52ea9bae42228d07ec09eb676433d7c4ed1ebdf0f1d1c29ed446f1ab8"
SRC_URI[aho-corasick.sha256sum] = "cc936419f96fa211c1b9166887b38e5e40b19958e5b895be7c1f93adec7071ac"
SRC_URI[anyhow.sha256sum] = "224afbd727c3d6e4b90103ece64b8d1b67fbb1973b1046c2281eed3f3803f800"
SRC_URI[askama.sha256sum] = "fb98f10f371286b177db5eeb9a6e5396609555686a35e1d4f7b9a9c6d8af0139"
SRC_URI[askama_derive.sha256sum] = "87bf87e6e8b47264efa9bde63d6225c6276a52e05e91bf37eaa8afd0032d6b71"
SRC_URI[askama_escape.sha256sum] = "619743e34b5ba4e9703bba34deac3427c72507c7159f5fd030aea8cac0cfe341"
SRC_URI[askama_shared.sha256sum] = "bf722b94118a07fcbc6640190f247334027685d4e218b794dbfe17c32bf38ed0"
SRC_URI[async-io.sha256sum] = "8c374dda1ed3e7d8f0d9ba58715f924862c63eae6849c92d3a18e7fbde9e2794"
SRC_URI[autocfg.sha256sum] = "d468802bab17cbc0cc575e9b053f41e72aa36bfa6b7f55e3529ffa43161b97fa"
SRC_URI[base64.sha256sum] = "9e1b586273c5702936fe7b7d6896644d8be71e6314cfe09d3167c95f712589e8"
SRC_URI[bincode.sha256sum] = "b1f45e9417d87227c7a56d22e471c6206462cba514c7590c09aff4cf6d1ddcad"
SRC_URI[bitflags.sha256sum] = "bef38d45163c2f1dde094a7dfd33ccf595c92905c8f8f4fdc18d06fb1037718a"
SRC_URI[block-buffer.sha256sum] = "69cce20737498f97b993470a6e536b8523f0af7892a4f928cceb1ac5e52ebe7e"
SRC_URI[block-buffer_0.9.0.sha256sum] = "4152116fd6e9dadb291ae18fc1ec3575ed6d84c29642d97890f4b4a3417297e4"
SRC_URI[block-modes.sha256sum] = "2cb03d1bed155d89dce0f845b7899b18a9a163e148fd004e1c28421a783e2d8e"
SRC_URI[block-padding.sha256sum] = "8d696c370c750c948ada61c69a0ee2cbbb9c50b1019ddb86d9317157a99c2cae"
SRC_URI[bstr.sha256sum] = "b7f0778972c64420fdedc63f09919c8a88bda7b25135357fd25a5d9f3257e832"
SRC_URI[byteorder.sha256sum] = "14c189c53d098945499cdfa7ecc63567cf3886b3332b312a5b4585d8d3a6a610"
SRC_URI[bytes.sha256sum] = "89b2fd2a0dcf38d7971e2194b6b6eebab45ae01067456a7fd93d5547a61b70be"
SRC_URI[bytesize.sha256sum] = "38fcc2979eff34a4b84e1cf9a1e3da42a7d44b3b690a40cdcb23e3d556cfb2e5"
SRC_URI[bzip2-sys.sha256sum] = "736a955f3fa7875102d57c82b8cac37ec45224a07fd32d58f9f7a186b6cd4cdc"
SRC_URI[bzip2.sha256sum] = "bdb116a6ef3f6c3698828873ad02c3014b3c85cadb88496095628e3ef1e347f8"
SRC_URI[cab.sha256sum] = "ae6b4de23c7d39c0631fd3cc952d87951c86c75a13812d7247cb7a896e7b3551"
SRC_URI[camino.sha256sum] = "6031a462f977dd38968b6f23378356512feeace69cef817e1a4475108093cec3"
SRC_URI[cargo-options.sha256sum] = "860cd643171bc868500aff16c2405559b42fc71bd3130d761c2847b3e9e71cdc"
SRC_URI[cargo-platform.sha256sum] = "cbdb825da8a5df079a43676dbe042702f1707b1109f713a01420fbb4cc71fa27"
SRC_URI[cargo-xwin.sha256sum] = "f574a8d2827f03d03829efb03607297ab3cfd82583f1a1e6d9ec211ee4741433"
SRC_URI[cargo-zigbuild.sha256sum] = "b56c289fa331582c3637f30a066fdd442fa7e7388541d97e76bc9a15d5688096"
SRC_URI[cargo_metadata.sha256sum] = "08a1ec454bc3eead8719cb56e15dbbfecdbc14e4b3a3ae4936cc6e31f5fc0d07"
SRC_URI[cbindgen.sha256sum] = "a6358dedf60f4d9b8db43ad187391afe959746101346fe51bb978126bec61dfb"
SRC_URI[cc.sha256sum] = "50d30906286121d95be3d479533b458f87493b30a4b5f79a607db8f5d11aa91f"
SRC_URI[cfb.sha256sum] = "d38f2da7a0a2c4ccf0065be06397cc26a81f4e528be095826eee9d4adbb8c60f"
SRC_URI[cfg-if.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[charset.sha256sum] = "18e9079d1a12a2cc2bffb5db039c43661836ead4082120d5844f02555aca2d46"
SRC_URI[chumsky.sha256sum] = "8d02796e4586c6c41aeb68eae9bfb4558a522c35f1430c14b40136c3706e09e4"
SRC_URI[cipher.sha256sum] = "7ee52072ec15386f770805afd189a01c8841be8696bed250fa2f13c4c0d6dfb7"
SRC_URI[clap.sha256sum] = "a7db700bc935f9e43e88d00b0850dae18a63773cfbec6d8e070fccf7fef89a39"
SRC_URI[clap_complete.sha256sum] = "10861370d2ba66b0f5989f83ebf35db6421713fd92351790e7fdd6c36774c56b"
SRC_URI[clap_complete_command.sha256sum] = "4160b4a4f72ef58bd766bad27c09e6ef1cc9d82a22f6a0f55d152985a4a48e31"
SRC_URI[clap_complete_fig.sha256sum] = "46b30e010e669cd021e5004f3be26cff6b7c08d2a8a0d65b48d43a8cc0efd6c3"
SRC_URI[clap_derive.sha256sum] = "0177313f9f02afc995627906bbd8967e2be069f5261954222dac78290c2b9014"
SRC_URI[clap_lex.sha256sum] = "0d4198f73e42b4936b35b5bb248d81d2b595ecb170da0bac7655c54eedfa8da8"
SRC_URI[cli-table.sha256sum] = "adfbb116d9e2c4be7011360d0c0bee565712c11e969c9609b25b619366dc379d"
SRC_URI[concolor.sha256sum] = "318d6c16e73b3a900eb212ad6a82fc7d298c5ab8184c7a9998646455bc474a16"
SRC_URI[configparser.sha256sum] = "5458d9d1a587efaf5091602c59d299696a3877a439c8f6d461a2d3cce11df87a"
SRC_URI[console.sha256sum] = "c3d79fbe8970a77e3e34151cc13d3b3e248aa0faaecb9f6091fa07ebefe5ad60"
SRC_URI[content_inspector.sha256sum] = "b7bda66e858c683005a53a9a60c69a4aca7eeaa45d124526e389f7aec8e62f38"
SRC_URI[core-foundation-sys.sha256sum] = "5827cebf4670468b8772dd191856768aedcb1b0278a04f989f7766351917b9dc"
SRC_URI[core-foundation.sha256sum] = "194a7a9e6de53fa55116934067c844d9d749312f75c6f6d0980e8c252f8c2146"
SRC_URI[cpufeatures.sha256sum] = "28d997bd5e24a5928dd43e46dc529867e207907fe0b239c3477d924f7f2ca320"
SRC_URI[crc32fast.sha256sum] = "b540bd8bc810d3885c6ea91e2018302f68baba2129ab3e88f32389ee9370880d"
SRC_URI[crossbeam-utils.sha256sum] = "3c063cd8cc95f5c377ed0d4b49a4b21f632396ff690e8470c29b3359b346984b"
SRC_URI[crypto-common.sha256sum] = "1bfb12502f3fc46cca1bb51ac28df9d618d813cdc3d2f25b9fe775a34af26bb3"
SRC_URI[ctor.sha256sum] = "6d2301688392eb071b0bf1a37be05c469d3cc4dbbd95df672fe28ab021e6a096"
SRC_URI[data-encoding.sha256sum] = "23d8666cb01533c39dde32bcbab8e227b4ed6679b2c925eba05feabea39508fb"
SRC_URI[derivative.sha256sum] = "fcc3dd5e9e9c0b295d6e1e4d811fb6f157d5ffd784b8d202fc62eac8035a770b"
SRC_URI[dialoguer.sha256sum] = "af3c796f3b0b408d9fd581611b47fa850821fcb84aa640b83a3c1a5be2d691f2"
SRC_URI[diff.sha256sum] = "56254986775e3233ffa9c4d7d3faaf6d36a2c09d30b20687e9f88bc8bafc16c8"
SRC_URI[digest.sha256sum] = "8168378f4e5023e7218c89c891c0fd8ecdb5e5e4f18cb78f38cf245dd021e76f"
SRC_URI[digest_0.9.0.sha256sum] = "d3dd60d1080a57a05ab032377049e0591415d2b31afd7028356dbf3cc6dcb066"
SRC_URI[dirs-sys.sha256sum] = "1b1d1d91c932ef41c0f2663aa8b0ca0342d444d842c06914aa0a7e352d0bada6"
SRC_URI[dirs.sha256sum] = "ca3aa72a6f96ea37bbc5aa912f6788242832f75369bdfdadcb0e38423f100059"
SRC_URI[dunce.sha256sum] = "0bd4b30a6560bbd9b4620f4de34c3f14f60848e58a9b7216801afcb4c7b31c3c"
SRC_URI[either.sha256sum] = "7fcaabb2fef8c910e7f4c7ce9f67a1283a1715879a7c230ca9d6d1ae31f16d91"
SRC_URI[encode_unicode.sha256sum] = "a357d28ed41a50f9c765dbfe56cbc04a64e53e5fc58ba79fbc34c10ef3df831f"
SRC_URI[encoding_rs.sha256sum] = "071a31f4ee85403370b58aca746f01041ede6f0da2730960ad001edc2b71b394"
SRC_URI[enumflags2.sha256sum] = "83c8d82922337cd23a15f88b70d8e4ef5f11da38dd7cdb55e84dd5de99695da0"
SRC_URI[errno.sha256sum] = "f639046355ee4f37944e44f60642c6f3a7efa3cf6b78c78a0d989a8ce6c396a1"
SRC_URI[fastrand.sha256sum] = "e51093e27b0797c359783294ca4f0a911c270184cb10f85783b118614a1501be"
SRC_URI[fat-macho.sha256sum] = "67f07131a2b944c2b42b6a58104600ef049c11df5454478d2b44ff5dfe58d149"
SRC_URI[filetime.sha256sum] = "4e884668cd0c7480504233e951174ddc3b382f7c2666e3b7310b5c4e7b0c37f9"
SRC_URI[flate2.sha256sum] = "a8a2db397cb1c8772f31494cb8917e48cd1e64f0fa7efac59fbd741a0a8ce841"
SRC_URI[fnv.sha256sum] = "3f9eec918d3f24069decb9af1554cad7c880e2da24a9afd88aca000531ab82c1"
SRC_URI[foreign-types.sha256sum] = "f6f339eb8adc052cd2ca78910fda869aefa38d22d5cb648e6485e4d3fc06f3b1"
SRC_URI[form_urlencoded.sha256sum] = "a9c384f161156f5260c24a097c56119f9be8c798586aecc13afbcbe7b7e26bf8"
SRC_URI[fs-err.sha256sum] = "0845fa252299212f0389d64ba26f34fa32cfe41588355f21ed507c59a0f64541"
SRC_URI[futures.sha256sum] = "13e2792b0ff0340399d58445b88fd9770e3489eff258a4cbc1523418f12abf84"
SRC_URI[getrandom.sha256sum] = "c05aeb6a22b8f62540c194aac980f2115af067bfe15a0734d7277a768d396b31"
SRC_URI[glob.sha256sum] = "d2fabcfbdc87f4758337ca535fb41a6d701b65693ce38287d856d1674551ec9b"
SRC_URI[globset.sha256sum] = "029d74589adefde59de1a0c4f4732695c32805624aec7b68d91503d4dba79afc"
SRC_URI[goblin.sha256sum] = "0d6b4de4a8eb6c46a8c77e1d3be942cb9a8bf073c22374578e5ba4b08ed0ff68"
SRC_URI[hashbrown.sha256sum] = "8a9ee70c43aaf417c914396645a0fa852624801b24ebb7ae78fe8272889ac888"
SRC_URI[heck.sha256sum] = "95505c38b4572b2d910cecb0281560f54b440a19336cbbcb27bf6ce6adc6f5a8"
SRC_URI[hermit-abi.sha256sum] = "ee512640fe35acbfb4bb779db6f0d80704c2cacfa2e39b601ef3e3f47d1ae4c7"
SRC_URI[hkdf.sha256sum] = "01706d578d5c281058480e673ae4086a9f4710d8df1ad80a5b03e39ece5f886b"
SRC_URI[hmac.sha256sum] = "2a2a2320eb7ec0ebe8da8f744d7812d9fc4cb4d09344ac01898dbcb6a20ae69b"
SRC_URI[humantime-serde.sha256sum] = "57a3db5ea5923d99402c94e9feb261dc5ee9b4efa158b0315f788cf549cc200c"
SRC_URI[humantime.sha256sum] = "9a3a5bfb195931eeb336b2a7b4d761daec841b97f947d34394601737a7bba5e4"
SRC_URI[idna.sha256sum] = "e14ddfc70884202db2244c223200c204c2bda1bc6e0998d11b5e024d657209e6"
SRC_URI[ignore.sha256sum] = "713f1b139373f96a2e0ce3ac931cd01ee973c3c5dd7c40c0c2efe96ad2b6751d"
SRC_URI[indexmap.sha256sum] = "1885e79c1fc4b10f0e172c475f458b7f7b93061064d98c3293e98c5ba0c8b399"
SRC_URI[indicatif.sha256sum] = "cef509aa9bc73864d6756f0d34d35504af3cf0844373afe9b8669a5b8005a729"
SRC_URI[indoc.sha256sum] = "6fe2b9d82064e8a0226fddb3547f37f28eaa46d0fc210e275d835f08cf3b76a7"
SRC_URI[instant.sha256sum] = "7a5bbe824c507c5da5956355e86a746d82e0e1464f65d862cc5e71da70e94b2c"
SRC_URI[io-lifetimes.sha256sum] = "e7d6c6f8c91b4b9ed43484ad1a938e393caf35960fce7f82a040497207bd8e9e"
SRC_URI[is-terminal.sha256sum] = "28dfb6c8100ccc63462345b67d1bbc3679177c75ee4bf59bf29c8b1d110b8189"
SRC_URI[itertools.sha256sum] = "b0fd2260e829bddf4cb6ea802289de2f86d6a7a690192fbe91b3f46e0f2c8473"
SRC_URI[itoa.sha256sum] = "fad582f4b9e86b6caa621cabeb0963332d92eea04729ab12892c2533951e6440"
SRC_URI[keyring.sha256sum] = "ba264b266563c1363dcce004776cbf198d7422a4262f77f4ca285bf26ae30955"
SRC_URI[lazy_static.sha256sum] = "e2abad23fbc42b3700f2f279844dc832adb2b2eb069b2df918f455c4e18cc646"
SRC_URI[lddtree.sha256sum] = "7580a02d700ecc9e06c72b7aace6e74427a56a69310f18fdd420a5fac3832969"
SRC_URI[libc.sha256sum] = "201de327520df007757c1f0adce6e827fe8562fbc28bfd9c15571c66ca1f5f79"
SRC_URI[linux-raw-sys.sha256sum] = "f051f77a7c8e6957c0696eac88f26b0117e54f52d3fc682ab19397a8812846a4"
SRC_URI[lock_api.sha256sum] = "435011366fe56583b16cf956f9df0095b405b82d76425bc8981c0e22e60ec4df"
SRC_URI[log.sha256sum] = "abb12e687cfb44aa40f41fc3978ef76448f9b6038cad6aef4259d3c095a2382e"
SRC_URI[lzxd.sha256sum] = "784462f20dddd9dfdb45de963fa4ad4a288cb10a7889ac5d2c34fb6481c6b213"
SRC_URI[mailparse.sha256sum] = "8cae768a50835557749599277fc59f7c728118724eb34185e8feb633ef266a32"
SRC_URI[matchers.sha256sum] = "8263075bb86c5a1b1427b5ae862e8889656f126e9f77c484496e8b47cf5c5558"
SRC_URI[memchr.sha256sum] = "2dffe52ecf27772e601905b7522cb4ef790d2cc203488bbd0e2fe85fcb74566d"
SRC_URI[mime.sha256sum] = "2a60c7ce501c71e03a9c9c0d35b861413ae925bd979cc7a4e30d060069aaac8d"
SRC_URI[mime_guess.sha256sum] = "4192263c238a5f0d0c6bfd21f336a313a4ce1c450542449ca191bb657b4642ef"
SRC_URI[minijinja.sha256sum] = "41ec399da2025bb79da141e6dcf7e5b4d73f8161ef73d3c28b99850c56620378"
SRC_URI[miniz_oxide.sha256sum] = "b275950c28b37e794e8c55d88aeb5e139d0ce23fdbbeda68f8d7174abdf9e8fa"
SRC_URI[msi.sha256sum] = "eaa7bfcd0ffc3b4dc4a555e5ada4d302b4b6b5ce8d6bc07a6ea703ea63aff149"
SRC_URI[multipart.sha256sum] = "00dec633863867f29cb39df64a397cdf4a6354708ddd7759f70c7fb51c5f9182"
SRC_URI[native-tls.sha256sum] = "07226173c32f2926027b63cce4bcd8076c3552846cbe7925f3aaffeac0a3b92e"
SRC_URI[nb-connect.sha256sum] = "b1bb540dc6ef51cfe1916ec038ce7a620daf3a111e2502d745197cd53d6bca15"
SRC_URI[nix.sha256sum] = "e4916f159ed8e5de0082076562152a76b7a1f64a01fd9d1e0fea002c37624faf"
SRC_URI[nom.sha256sum] = "d273983c5a657a70a3e8f2a01329822f3b8c8172b73826411a55751e404a0a4a"
SRC_URI[nom8.sha256sum] = "ae01545c9c7fc4486ab7debaf2aad7003ac19431791868fb2e8066df97fad2f8"
SRC_URI[normalize-line-endings.sha256sum] = "61807f77802ff30975e01f4f071c8ba10c022052f98b3294119f3e615d13e5be"
SRC_URI[normpath.sha256sum] = "3a37f4eb793d70ebef49f4643fe4b8c0e60d266e3fb607158e64b6ee24b0d6d4"
SRC_URI[nu-ansi-term.sha256sum] = "77a8165726e8236064dbb45459242600304b42a5ea24ee2948e18e023bf7ba84"
SRC_URI[num-bigint.sha256sum] = "f93ab6289c7b344a8a9f60f88d80aa20032336fe78da341afc91c8a2341fc75f"
SRC_URI[num-complex.sha256sum] = "02e0d21255c828d6f128a1e41534206671e8c3ea0c62f32291e808dc82cff17d"
SRC_URI[num-integer.sha256sum] = "225d3389fb3509a24c93f5c29eb6bde2586b98d9f016636dff58d7c6f7569cd9"
SRC_URI[num-iter.sha256sum] = "7d03e6c028c5dc5cac6e2dec0efda81fc887605bb3d884578bb6d6bf7514e252"
SRC_URI[num-rational.sha256sum] = "0638a1c9d0a3c0914158145bc76cff373a75a627e6ecbfb71cbe6f453a5a19b0"
SRC_URI[num-traits.sha256sum] = "578ede34cf02f8924ab9447f50c28075b4d3e5b269972345e7e0372b38c6cdcd"
SRC_URI[num.sha256sum] = "43db66d1170d347f9a065114077f7dccb00c1b9478c89384490a3425279a4606"
SRC_URI[number_prefix.sha256sum] = "830b246a0e5f20af87141b25c173cd1b609bd7779a4617d6ec582abaf90870f3"
SRC_URI[once_cell.sha256sum] = "b7e5500299e16ebb147ae15a00a942af264cf3688f47923b8fc2cd5858f23ad3"
SRC_URI[opaque-debug.sha256sum] = "624a8340c38c1b80fd549087862da4ba43e08858af025b236e509b6649fc13d5"
SRC_URI[openssl-macros.sha256sum] = "b501e44f11665960c7e7fcf062c7d96a14ade4aa98116c004b2e37b5be7d736c"
SRC_URI[openssl-probe.sha256sum] = "ff011a302c396a5197692431fc1948019154afc178baf7d8e37367442a4601cf"
SRC_URI[openssl-sys.sha256sum] = "23bbbf7854cd45b83958ebe919f0e8e516793727652e27fda10a8384cfc790b7"
SRC_URI[openssl.sha256sum] = "b102428fd03bc5edf97f62620f7298614c45cedf287c271e7ed450bbaf83f2e1"
SRC_URI[os_pipe.sha256sum] = "c6a252f1f8c11e84b3ab59d7a488e48e4478a93937e027076638c49536204639"
SRC_URI[os_str_bytes.sha256sum] = "9b7820b9daea5457c9f21c69448905d723fbd21136ccf521748f23fd49e723ee"
SRC_URI[output_vt100.sha256sum] = "628223faebab4e3e40667ee0b2336d34a5b960ff60ea743ddfdbcf7770bcfb66"
SRC_URI[overload.sha256sum] = "b15813163c1d831bf4a13c3610c05c0d03b39feb07f7e09fa234dac9b15aaf39"
SRC_URI[parking_lot.sha256sum] = "3742b2c103b9f06bc9fff0a37ff4912935851bee6d36f3c02bcc755bcfec228f"
SRC_URI[parking_lot_core.sha256sum] = "ba1ef8814b5c993410bb3adfad7a5ed269563e4a2f90c41f5d85be7fb47133bf"
SRC_URI[paste.sha256sum] = "d01a5bd0424d00070b0098dd17ebca6f961a959dead1dbcbbbc1d1cd8d3deeba"
SRC_URI[path-slash.sha256sum] = "1e91099d4268b0e11973f036e885d652fb0b21fedcf69738c627f94db6a44f42"
SRC_URI[pep440.sha256sum] = "8841b00ca6fabc903e8ecd496d9611db402e23f15e3d19b0b587e2ca653abd89"
SRC_URI[percent-encoding.sha256sum] = "478c572c3d73181ff3c2539045f6eb99e5491218eae919370993b890cdbdd98e"
SRC_URI[pin-project-lite.sha256sum] = "e0a7ae3ac2f1173085d398531c705756c94a4c56843785df85a60c1a0afac116"
SRC_URI[pkg-config.sha256sum] = "6ac9a59f73473f1b8d852421e59e64809f025994837ef743615c6d0c5b305160"
SRC_URI[plain.sha256sum] = "b4596b6d070b27117e987119b4dac604f3c58cfb0b191112e24771b2faeac1a6"
SRC_URI[platform-info.sha256sum] = "4e7c23cfae725ae06d9e43010153fa77bdfa8c827bf08fe4beeb2a3514e6be12"
SRC_URI[polling.sha256sum] = "22122d5ec4f9fe1b3916419b76be1e80bcb93f618d071d2edf841b137b2a2bd6"
SRC_URI[portable-atomic.sha256sum] = "26f6a7b87c2e435a3241addceeeff740ff8b7e76b74c13bf9acb17fa454ea00b"
SRC_URI[pretty_assertions.sha256sum] = "a25e9bcb20aa780fd0bb16b72403a9064d6b3f22f026946029acb941a50af755"
SRC_URI[proc-macro-crate.sha256sum] = "1d6ea3c4595b96363c13943497db34af4460fb474a95c43f4446ad341b8c9785"
SRC_URI[proc-macro-error-attr.sha256sum] = "a1be40180e52ecc98ad80b184934baf3d0d29f979574e439af5a55274b35f869"
SRC_URI[proc-macro-error.sha256sum] = "da25490ff9892aab3fcf7c36f08cfb902dd3e71ca0f9f9517bea02a73a5ce38c"
SRC_URI[proc-macro2.sha256sum] = "5d727cae5b39d21da60fa540906919ad737832fe0b1c165da3a34d6548c849d6"
SRC_URI[pyproject-toml.sha256sum] = "380405edf78a88a5789f6f19ec9b76de091b5dce31eddb7a43a7386814aaa8fb"
SRC_URI[python-pkginfo.sha256sum] = "0b8cf2d8981a1c967eebacac69c68a54d9786c1b84b813841d0aab2994705608"
SRC_URI[quote.sha256sum] = "8856d8364d252a14d474036ea1358d63c9e6965c8e5c1885c18f73d70bff9c7b"
SRC_URI[quoted_printable.sha256sum] = "a24039f627d8285853cc90dcddf8c1ebfaa91f834566948872b225b9a28ed1b6"
SRC_URI[rand.sha256sum] = "34af8d1a0e25924bc5b7c43c079c942339d8f0a8b57c39049bef581b46327404"
SRC_URI[rand_chacha.sha256sum] = "e6c10a63a0fa32252be49d21e7709d4d4baf8d231c2dbce1eaa8141b9b127d88"
SRC_URI[rand_core.sha256sum] = "ec0be4795e2f6a28069bec0b5ff3e2ac9bafc99e6a9a7dc3547996c5c816922c"
SRC_URI[rayon-core.sha256sum] = "356a0625f1954f730c0201cdab48611198dc6ce21f4acff55089b5a78e6e835b"
SRC_URI[rayon.sha256sum] = "6db3a213adf02b3bcfd2d3846bb41cb22857d131789e01df434fb7e7bc0759b7"
SRC_URI[redox_syscall.sha256sum] = "fb5a58c1855b4b6819d59012155603f0b22ad30cad752600aadfcb695265519a"
SRC_URI[redox_users.sha256sum] = "b033d837a7cf162d7993aded9304e30a83213c648b6e389db233191f891e5c2b"
SRC_URI[regex-automata.sha256sum] = "6c230d73fb8d8c1b9c0b3135c5142a8acee3a0558fb8db5cf1cb65f8d7862132"
SRC_URI[regex-syntax.sha256sum] = "456c603be3e8d448b072f410900c09faf164fbce2d480456f50eea6e25f9c848"
SRC_URI[regex.sha256sum] = "48aaa5748ba571fb95cd2c85c09f629215d3a6ece942baa100950af03a34f733"
SRC_URI[rfc2047-decoder.sha256sum] = "6e0df53c9deb8931ce779840148cda205fd17475ce59193ff7f8d136ef755481"
SRC_URI[ring.sha256sum] = "3053cf52e236a3ed746dfc745aa9cacf1b791d846bdaf412f60a8d7d6e17c8fc"
SRC_URI[rpassword.sha256sum] = "6678cf63ab3491898c0d021b493c94c9b221d91295294a2a5746eacbe5928322"
SRC_URI[rtoolbox.sha256sum] = "034e22c514f5c0cb8a10ff341b9b048b5ceb21591f31c8f44c43b960f9b3524a"
SRC_URI[rustc_version.sha256sum] = "bfa0f585226d2e68097d4f95d113b15b83a82e819ab25717ec0590d9584ef366"
SRC_URI[rustix.sha256sum] = "d4fdebc4b395b7fbb9ab11e462e20ed9051e7b16e42d24042c776eca0ac81b03"
SRC_URI[rustls.sha256sum] = "fff78fc74d175294f4e83b28343315ffcfb114b156f0185e9741cb5570f50e2f"
SRC_URI[rustversion.sha256sum] = "5583e89e108996506031660fe09baa5011b9dd0341b89029313006d1fb508d70"
SRC_URI[ryu.sha256sum] = "7b4b9743ed687d4b4bcedf9ff5eaa7398495ae14e61cba0a295704edbc7decde"
SRC_URI[same-file.sha256sum] = "93fc1dc3aaa9bfed95e02e6eadabb4baf7e3078b0bd1b4d7b6b0b68378900502"
SRC_URI[schannel.sha256sum] = "713cfb06c7059f3588fb8044c0fad1d09e3c01d225e25b9220dbfdcf16dbb1b3"
SRC_URI[scoped-tls.sha256sum] = "e1cf6437eb19a8f4a6cc0f7dca544973b0b78843adbfeb3683d1a94a0024a294"
SRC_URI[scroll.sha256sum] = "04c565b551bafbef4157586fa379538366e4385d42082f255bfd96e4fe8519da"
SRC_URI[scroll_derive.sha256sum] = "bdbda6ac5cd1321e724fa9cee216f3a61885889b896f073b8f82322789c5250e"
SRC_URI[sct.sha256sum] = "d53dcdb7c9f8158937a7981b48accfd39a43af418591a5d008c7b22b5e1b7ca4"
SRC_URI[secret-service.sha256sum] = "e1da5c423b8783185fd3fecd1c8796c267d2c089d894ce5a93c280a5d3f780a2"
SRC_URI[security-framework-sys.sha256sum] = "31c9bb296072e961fcbd8853511dd39c2d8be2deb1e17c6860b1d30732b323b4"
SRC_URI[security-framework.sha256sum] = "a332be01508d814fed64bf28f798a146d73792121129962fdf335bb3c49a4254"
SRC_URI[semver.sha256sum] = "58bc9567378fc7690d6b2addae4e60ac2eeea07becb2c64b9f218b53865cba2a"
SRC_URI[serde.sha256sum] = "bb7d1f0d3021d347a83e556fc4683dea2ea09d87bccdf88ff5c12545d89d5efb"
SRC_URI[serde_derive.sha256sum] = "af487d118eecd09402d70a5d72551860e788df87b464af30e5ea6a38c75c541e"
SRC_URI[serde_json.sha256sum] = "cad406b69c91885b5107daf2c29572f6c8cdb3c66826821e286c533490c0bc76"
SRC_URI[serde_repr.sha256sum] = "9a5ec9fa74a20ebbe5d9ac23dac1fc96ba0ecfe9f50f2843b52e537b10fbcb4e"
SRC_URI[sha2.sha256sum] = "82e6b795fe2e3b1e845bafcb27aa35405c4d47cdfc92af5fc8d3002f76cebdc0"
SRC_URI[sha256sum] = "57ddb61e394a2df623e89d013abc939f22c18cd5de64844f4fb11da2947ac3fe"
SRC_URI[sha2_0.9.9.sha256sum] = "4d58a1e1bf39749807d89cf2d98ac2dfa0ff1cb3faa38fbb64dd88ac8013d800"
SRC_URI[sharded-slab.sha256sum] = "900fba806f70c630b0a382d0d825e17a0f19fcd059a2ade1ff237bcddf446b31"
SRC_URI[shell-words.sha256sum] = "24188a676b6ae68c3b2cb3a01be17fbf7240ce009799bb56d5b1409051e78fde"
SRC_URI[shlex.sha256sum] = "43b2853a4d09f215c24cc5489c992ce46052d359b5109343cbafbf26bc62f8a3"
SRC_URI[similar.sha256sum] = "420acb44afdae038210c99e69aae24109f32f15500aa708e81d46c9f29d55fcf"
SRC_URI[siphasher.sha256sum] = "7bd3e3206899af3f8b12af284fafc038cc1dc2b41d1b89dd17297221c5d225de"
SRC_URI[smallvec.sha256sum] = "a507befe795404456341dfab10cef66ead4c041f62b8b11bbb92bffe5d0953e0"
SRC_URI[smawk.sha256sum] = "f67ad224767faa3c7d8b6d91985b78e70a1324408abcb1cfcc2be4c06bc06043"
SRC_URI[snapbox-macros.sha256sum] = "485e65c1203eb37244465e857d15a26d3a85a5410648ccb53b18bd44cb3a7336"
SRC_URI[snapbox.sha256sum] = "34eced5a65e76d5a00047986a83c65f80dc666faa27b5138f331659e2ca6bcf5"
SRC_URI[socks.sha256sum] = "f0c3dbbd9ae980613c6dd8e28a9407b50509d3803b57624d5dfe8315218cd58b"
SRC_URI[static_assertions.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[strsim.sha256sum] = "73473c0e59e6d5812c5dfe2a064a6444949f089e20eec9a2e5506596494e4623"
SRC_URI[syn.sha256sum] = "72b64191b275b66ffe2469e8af2c1cfe3bafa67b529ead792a6d0160888b4237"
SRC_URI[tar.sha256sum] = "4b55807c0344e1e6c04d7c965f5289c39a8d94ae23ed5c0b57aabac549f871c6"
SRC_URI[target-lexicon.sha256sum] = "8ae9980cab1db3fceee2f6c6f643d5d8de2997c58ee8d25fb0cc8a9e9e7348e5"
SRC_URI[tempfile.sha256sum] = "af18f7ae1acd354b992402e9ec5864359d693cd8a79dcbef59f76891701c1e95"
SRC_URI[termcolor.sha256sum] = "be55cf8942feac5c765c2c993422806843c9a9a45d4d5c407ad6dd2ea95eb9b6"
SRC_URI[terminal_size.sha256sum] = "cb20089a8ba2b69debd491f8d2d023761cbf196e999218c591fa1e7e15a21907"
SRC_URI[textwrap.sha256sum] = "222a222a5bfe1bba4a77b45ec488a741b3cb8872e5e499451fd7d0129c9c7c3d"
SRC_URI[thiserror-impl.sha256sum] = "1fb327af4685e4d03fa8cbcf1716380da910eeb2bb8be417e7f9fd3fb164f36f"
SRC_URI[thiserror.sha256sum] = "6a9cd18aa97d5c45c6603caea1da6628790b37f7a34b6ca89522331c5180fed0"
SRC_URI[thread_local.sha256sum] = "5516c27b78311c50bf42c071425c560ac799b11c30b31f87e3081965fe5e0180"
SRC_URI[time-core.sha256sum] = "2e153e1f1acaef8acc537e68b44906d2db6436e2b35ac2c6b42640fff91f00fd"
SRC_URI[time-macros.sha256sum] = "d967f99f534ca7e495c575c62638eebc2898a8c84c119b89e250477bc4ba16b2"
SRC_URI[time.sha256sum] = "a561bf4617eebd33bca6434b988f39ed798e527f51a1e797d0ee4f61c0a38376"
SRC_URI[toml.sha256sum] = "f4f7f0dd8d50a853a531c426359045b1998f04219d88799810762cd4ad314234"
SRC_URI[toml_datetime.sha256sum] = "808b51e57d0ef8f71115d8f3a01e7d3750d01c79cac4b3eda910f4389fdf92fd"
SRC_URI[toml_edit.sha256sum] = "a34cc558345efd7e88b9eda9626df2138b80bb46a7606f695e751c892bc7dac6"
SRC_URI[tracing-attributes.sha256sum] = "4017f8f45139870ca7e672686113917c71c7a6e02d4924eda67186083c03081a"
SRC_URI[tracing-core.sha256sum] = "24eb03ba0eab1fd845050058ce5e616558e8f8d8fca633e6b163fe25c797213a"
SRC_URI[tracing-log.sha256sum] = "78ddad33d2d10b1ed7eb9d1f518a5674713876e97e5bb9b7345a7984fbb4f922"
SRC_URI[tracing-serde.sha256sum] = "bc6b213177105856957181934e4920de57730fc69bf42c37ee5bb664d406d9e1"
SRC_URI[tracing-subscriber.sha256sum] = "a6176eae26dd70d0c919749377897b54a9276bd7061339665dd68777926b5a70"
SRC_URI[tracing.sha256sum] = "8ce8c33a8d48bd45d624a6e523445fd21ec13d3653cd51f681abf67418f54eb8"
SRC_URI[trycmd.sha256sum] = "01662d21325d18cd4acae7e1dc9f29a2a88b7fbb7f9bc427c4a692aaec5773ac"
SRC_URI[twox-hash.sha256sum] = "97fee6b57c6a41524a810daee9286c02d7752c4253064d0b05472833a438f675"
SRC_URI[unicase.sha256sum] = "50f37be617794602aabbeee0be4f259dc1778fabe05e2d67ee8f79326d5cb4f6"
SRC_URI[unicode-ident.sha256sum] = "84a22b9f218b40614adcb3f4ff08b703773ad44fa9423e4e0d346d5db86e4ebc"
SRC_URI[unicode-linebreak.sha256sum] = "c5faade31a542b8b35855fff6e8def199853b2da8da256da52f52f1316ee3137"
SRC_URI[unicode-width.sha256sum] = "c0edd1e5b14653f783770bce4a4dabb4a5108a5370a5f5d8cfe8710c361f6c8b"
SRC_URI[uniffi_bindgen.sha256sum] = "19d84dea610e893f4043354c71e4361386475365e6e2834aded4c8cebf940311"
SRC_URI[uniffi_checksum_derive.sha256sum] = "f55105cc7e1ac83ca1eb29587e3b7f65737f9142dc65d54b63502c2589c9d6a5"
SRC_URI[uniffi_meta.sha256sum] = "9f819a2d6f98e2e9758604f3f541c8200166868525d0329e232ce188f19eeeb4"
SRC_URI[uniffi_testing.sha256sum] = "0cd68c90ec2ab35abc868eae85eedd92b7cede34d38a57e356fce96b8f99d4ef"
SRC_URI[untrusted.sha256sum] = "a156c684c91ea7d62626509bce3cb4e1d9ed5c4d978f7b4352658f96a4c26b4a"
SRC_URI[ureq.sha256sum] = "338b31dd1314f68f3aabf3ed57ab922df95ffcd902476ca7ba3c4ce7b908c46d"
SRC_URI[url.sha256sum] = "0d68c799ae75762b8c3fe375feb6600ef5602c883c5d21eb51c09f22b83c4643"
SRC_URI[uuid.sha256sum] = "1674845326ee10d37ca60470760d4288a6f80f304007d92e5c53bab78c9cfd79"
SRC_URI[vcpkg.sha256sum] = "accd4ea62f7bb7a82fe23066fb0957d48ef677f6eeb8215f372f52e48bb32426"
SRC_URI[version_check.sha256sum] = "49874b5167b65d7193b8aba1567f5c7d93d001cafc34600cee003eda787e483f"
SRC_URI[versions.sha256sum] = "ee97e1d97bd593fb513912a07691b742361b3dd64ad56f2c694ea2dbfe0665d3"
SRC_URI[wait-timeout.sha256sum] = "9f200f5b12eb75f8c1ed65abd4b2db8a6e1b138a20de009dacee265a2498f3f6"
SRC_URI[walkdir.sha256sum] = "808cf2735cd4b6866113f648b791c6adc5714537bc222d9347bb203386ffda56"
SRC_URI[webpki-roots.sha256sum] = "b6c71e40d7d2c34a5106301fb632274ca37242cd0c9d3e64dbece371a40a2d87"
SRC_URI[webpki.sha256sum] = "f095d78192e208183081cc07bc5515ef55216397af48b873e5edcd72637fa1bd"
SRC_URI[weedle2.sha256sum] = "2e79c5206e1f43a2306fd64bdb95025ee4228960f2e6c5a8b173f3caaf807741"
SRC_URI[which.sha256sum] = "2441c784c52b289a054b7201fc93253e288f094e2f4be9058343127c4226a269"
SRC_URI[winapi-i686-pc-windows-gnu.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-util.sha256sum] = "70ec6ce85bb158151cae5e5c87f95a8e97d2c0c4b001223f33a334e3ce5de178"
SRC_URI[winapi-x86_64-pc-windows-gnu.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"
SRC_URI[winapi.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"
SRC_URI[windows-sys.sha256sum] = "5a3e1820f08b8513f676f7ab6c1f99ff312fb97b553d30ff4dd86f9f15728aa7"
SRC_URI[windows_aarch64_gnullvm.sha256sum] = "8c9864e83243fdec7fc9c5444389dcbbfd258f745e7853198f365e3c4968a608"
SRC_URI[windows_aarch64_msvc.sha256sum] = "4c8b1b673ffc16c47a9ff48570a9d85e25d265735c503681332589af6253c6c7"
SRC_URI[windows_i686_gnu.sha256sum] = "de3887528ad530ba7bdbb1faa8275ec7a1155a45ffa57c37993960277145d640"
SRC_URI[windows_i686_msvc.sha256sum] = "bf4d1122317eddd6ff351aa852118a2418ad4214e6613a50e0191f7004372605"
SRC_URI[windows_x86_64_gnu.sha256sum] = "c1040f221285e17ebccbc2591ffdc2d44ee1f9186324dd3e84e99ac68d699c45"
SRC_URI[windows_x86_64_gnullvm.sha256sum] = "628bfdf232daa22b0d64fdb62b09fcc36bb01f05a3939e20ab73aaf9470d0463"
SRC_URI[windows_x86_64_msvc.sha256sum] = "447660ad36a13288b1db4d4248e857b510e8c3a225c822ba4fb748c0aafecffd"
SRC_URI[xattr.sha256sum] = "6d1526bbe5aaeb5eb06885f4d987bcdfa5e23187055de9b83fe00156a821fabc"
SRC_URI[xwin.sha256sum] = "5c53c43cb1b0385c4e1482f160cd72e4e43b8a9f436a42e3f539480c52056492"
SRC_URI[yansi.sha256sum] = "09041cd90cf85f7f8b2df60c646f853b7f535ce68f85244eb6731cf89fa498ec"
SRC_URI[zbus.sha256sum] = "9cbeb2291cd7267a94489b71376eda33496c1b9881adf6b36f26cc2779f3fc49"
SRC_URI[zbus_macros.sha256sum] = "fa3959a7847cf95e3d51e312856617c5b1b77191176c65a79a5f14d778bbe0a6"
SRC_URI[zip.sha256sum] = "0445d0fbc924bb93539b4316c11afb121ea39296f99a3c4c9edad09e3658cdef"
SRC_URI[zvariant.sha256sum] = "a68c7b55f2074489b7e8e07d2d0a6ee6b4f233867a653c664d8020ba53692525"
SRC_URI[zvariant_derive.sha256sum] = "e4ca5e22593eb4212382d60d26350065bf2a02c34b85bc850474a74b589a3de9"

SRC_URI:append = " \
    crate://crates.io/adler/1.0.2 \
    crate://crates.io/aes/0.7.5 \
    crate://crates.io/aho-corasick/0.7.20 \
    crate://crates.io/anyhow/1.0.69 \
    crate://crates.io/askama/0.11.1 \
    crate://crates.io/askama_derive/0.11.2 \
    crate://crates.io/askama_escape/0.10.3 \
    crate://crates.io/askama_shared/0.12.2 \
    crate://crates.io/async-io/1.12.0 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/base64/0.13.1 \
    crate://crates.io/bincode/1.3.3 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/block-buffer/0.10.3 \
    crate://crates.io/block-buffer/0.9.0;name=block-buffer_0.9.0 \
    crate://crates.io/block-modes/0.8.1 \
    crate://crates.io/block-padding/0.2.1 \
    crate://crates.io/bstr/1.2.0 \
    crate://crates.io/byteorder/1.4.3 \
    crate://crates.io/bytes/1.4.0 \
    crate://crates.io/bytesize/1.2.0 \
    crate://crates.io/bzip2-sys/0.1.11+1.0.8 \
    crate://crates.io/bzip2/0.4.4 \
    crate://crates.io/cab/0.4.1 \
    crate://crates.io/camino/1.1.3 \
    crate://crates.io/cargo-options/0.5.3 \
    crate://crates.io/cargo-platform/0.1.2 \
    crate://crates.io/cargo-xwin/0.13.3 \
    crate://crates.io/cargo-zigbuild/0.14.3 \
    crate://crates.io/cargo_metadata/0.15.3 \
    crate://crates.io/cbindgen/0.24.3 \
    crate://crates.io/cc/1.0.79 \
    crate://crates.io/cfb/0.7.3 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/charset/0.1.3 \
    crate://crates.io/chumsky/0.8.0 \
    crate://crates.io/cipher/0.3.0 \
    crate://crates.io/clap/4.0.32 \
    crate://crates.io/clap_complete/4.0.7 \
    crate://crates.io/clap_complete_command/0.4.0 \
    crate://crates.io/clap_complete_fig/4.0.2 \
    crate://crates.io/clap_derive/4.0.21 \
    crate://crates.io/clap_lex/0.3.0 \
    crate://crates.io/cli-table/0.4.7 \
    crate://crates.io/concolor/0.0.11 \
    crate://crates.io/configparser/3.0.2 \
    crate://crates.io/console/0.15.5 \
    crate://crates.io/content_inspector/0.2.4 \
    crate://crates.io/core-foundation-sys/0.8.3 \
    crate://crates.io/core-foundation/0.9.3 \
    crate://crates.io/cpufeatures/0.2.5 \
    crate://crates.io/crc32fast/1.3.2 \
    crate://crates.io/crossbeam-utils/0.8.15 \
    crate://crates.io/crypto-common/0.1.6 \
    crate://crates.io/ctor/0.1.26 \
    crate://crates.io/data-encoding/2.3.3 \
    crate://crates.io/derivative/2.2.0 \
    crate://crates.io/dialoguer/0.10.3 \
    crate://crates.io/diff/0.1.13 \
    crate://crates.io/digest/0.10.6 \
    crate://crates.io/digest/0.9.0;name=digest_0.9.0 \
    crate://crates.io/dirs-sys/0.3.7 \
    crate://crates.io/dirs/4.0.0 \
    crate://crates.io/dunce/1.0.3 \
    crate://crates.io/either/1.8.1 \
    crate://crates.io/encode_unicode/0.3.6 \
    crate://crates.io/encoding_rs/0.8.32 \
    crate://crates.io/enumflags2/0.6.4 \
    crate://crates.io/errno/0.2.8 \
    crate://crates.io/fastrand/1.9.0 \
    crate://crates.io/fat-macho/0.4.6 \
    crate://crates.io/filetime/0.2.19 \
    crate://crates.io/flate2/1.0.25 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/foreign-types/0.3.2 \
    crate://crates.io/form_urlencoded/1.1.0 \
    crate://crates.io/fs-err/2.9.0 \
    crate://crates.io/futures/0.3.26 \
    crate://crates.io/getrandom/0.2.8 \
    crate://crates.io/glob/0.3.1 \
    crate://crates.io/globset/0.4.10 \
    crate://crates.io/goblin/0.6.1 \
    crate://crates.io/hashbrown/0.12.3 \
    crate://crates.io/heck/0.4.1 \
    crate://crates.io/hermit-abi/0.2.6 \
    crate://crates.io/hkdf/0.11.0 \
    crate://crates.io/hmac/0.11.0 \
    crate://crates.io/humantime-serde/1.1.1 \
    crate://crates.io/humantime/2.1.0 \
    crate://crates.io/idna/0.3.0 \
    crate://crates.io/ignore/0.4.18 \
    crate://crates.io/indexmap/1.9.2 \
    crate://crates.io/indicatif/0.17.3 \
    crate://crates.io/indoc/2.0.0 \
    crate://crates.io/instant/0.1.12 \
    crate://crates.io/io-lifetimes/1.0.4 \
    crate://crates.io/is-terminal/0.4.2 \
    crate://crates.io/itertools/0.10.5 \
    crate://crates.io/itoa/1.0.5 \
    crate://crates.io/keyring/1.2.1 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/lddtree/0.3.2 \
    crate://crates.io/libc/0.2.139 \
    crate://crates.io/linux-raw-sys/0.1.4 \
    crate://crates.io/lock_api/0.4.9 \
    crate://crates.io/log/0.4.17 \
    crate://crates.io/lzxd/0.1.4 \
    crate://crates.io/mailparse/0.13.8 \
    crate://crates.io/matchers/0.1.0 \
    crate://crates.io/memchr/2.5.0 \
    crate://crates.io/mime/0.3.16 \
    crate://crates.io/mime_guess/2.0.4 \
    crate://crates.io/minijinja/0.30.5 \
    crate://crates.io/miniz_oxide/0.6.2 \
    crate://crates.io/msi/0.5.1 \
    crate://crates.io/multipart/0.18.0 \
    crate://crates.io/native-tls/0.2.11 \
    crate://crates.io/nb-connect/1.2.0 \
    crate://crates.io/nix/0.22.3 \
    crate://crates.io/nom/7.1.3 \
    crate://crates.io/nom8/0.2.0 \
    crate://crates.io/normalize-line-endings/0.3.0 \
    crate://crates.io/normpath/1.0.1 \
    crate://crates.io/nu-ansi-term/0.46.0 \
    crate://crates.io/num-bigint/0.4.3 \
    crate://crates.io/num-complex/0.4.3 \
    crate://crates.io/num-integer/0.1.45 \
    crate://crates.io/num-iter/0.1.43 \
    crate://crates.io/num-rational/0.4.1 \
    crate://crates.io/num-traits/0.2.15 \
    crate://crates.io/num/0.4.0 \
    crate://crates.io/number_prefix/0.4.0 \
    crate://crates.io/once_cell/1.17.1 \
    crate://crates.io/opaque-debug/0.3.0 \
    crate://crates.io/openssl-macros/0.1.0 \
    crate://crates.io/openssl-probe/0.1.5 \
    crate://crates.io/openssl-sys/0.9.80 \
    crate://crates.io/openssl/0.10.45 \
    crate://crates.io/os_pipe/1.1.2 \
    crate://crates.io/os_str_bytes/6.4.1 \
    crate://crates.io/output_vt100/0.1.3 \
    crate://crates.io/overload/0.1.1 \
    crate://crates.io/parking_lot/0.12.1 \
    crate://crates.io/parking_lot_core/0.9.6 \
    crate://crates.io/paste/1.0.11 \
    crate://crates.io/path-slash/0.2.1 \
    crate://crates.io/pep440/0.2.0 \
    crate://crates.io/percent-encoding/2.2.0 \
    crate://crates.io/pin-project-lite/0.2.9 \
    crate://crates.io/pkg-config/0.3.26 \
    crate://crates.io/plain/0.2.3 \
    crate://crates.io/platform-info/1.0.2 \
    crate://crates.io/polling/2.5.2 \
    crate://crates.io/portable-atomic/0.3.19 \
    crate://crates.io/pretty_assertions/1.3.0 \
    crate://crates.io/proc-macro-crate/0.1.5 \
    crate://crates.io/proc-macro-error-attr/1.0.4 \
    crate://crates.io/proc-macro-error/1.0.4 \
    crate://crates.io/proc-macro2/1.0.51 \
    crate://crates.io/pyproject-toml/0.3.1 \
    crate://crates.io/python-pkginfo/0.5.5 \
    crate://crates.io/quote/1.0.23 \
    crate://crates.io/quoted_printable/0.4.7 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.6.4 \
    crate://crates.io/rayon-core/1.10.2 \
    crate://crates.io/rayon/1.6.1 \
    crate://crates.io/redox_syscall/0.2.16 \
    crate://crates.io/redox_users/0.4.3 \
    crate://crates.io/regex-automata/0.1.10 \
    crate://crates.io/regex-syntax/0.6.28 \
    crate://crates.io/regex/1.7.1 \
    crate://crates.io/rfc2047-decoder/0.2.1 \
    crate://crates.io/ring/0.16.20 \
    crate://crates.io/rpassword/7.2.0 \
    crate://crates.io/rtoolbox/0.0.1 \
    crate://crates.io/rustc_version/0.4.0 \
    crate://crates.io/rustix/0.36.7 \
    crate://crates.io/rustls/0.20.8 \
    crate://crates.io/rustversion/1.0.11 \
    crate://crates.io/ryu/1.0.12 \
    crate://crates.io/same-file/1.0.6 \
    crate://crates.io/schannel/0.1.21 \
    crate://crates.io/scoped-tls/1.0.1 \
    crate://crates.io/scroll/0.11.0 \
    crate://crates.io/scroll_derive/0.11.0 \
    crate://crates.io/sct/0.7.0 \
    crate://crates.io/secret-service/2.0.2 \
    crate://crates.io/security-framework-sys/2.8.0 \
    crate://crates.io/security-framework/2.8.2 \
    crate://crates.io/semver/1.0.16 \
    crate://crates.io/serde/1.0.152 \
    crate://crates.io/serde_derive/1.0.152 \
    crate://crates.io/serde_json/1.0.93 \
    crate://crates.io/serde_repr/0.1.10 \
    crate://crates.io/sha2/0.10.6 \
    crate://crates.io/sha2/0.9.9;name=sha2_0.9.9 \
    crate://crates.io/sharded-slab/0.1.4 \
    crate://crates.io/shell-words/1.1.0 \
    crate://crates.io/shlex/1.1.0 \
    crate://crates.io/similar/2.2.1 \
    crate://crates.io/siphasher/0.3.10 \
    crate://crates.io/smallvec/1.10.0 \
    crate://crates.io/smawk/0.3.1 \
    crate://crates.io/snapbox-macros/0.3.1 \
    crate://crates.io/snapbox/0.4.4 \
    crate://crates.io/socks/0.3.4 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/strsim/0.10.0 \
    crate://crates.io/syn/1.0.109 \
    crate://crates.io/tar/0.4.38 \
    crate://crates.io/target-lexicon/0.12.6 \
    crate://crates.io/tempfile/3.4.0 \
    crate://crates.io/termcolor/1.2.0 \
    crate://crates.io/terminal_size/0.2.3 \
    crate://crates.io/textwrap/0.16.0 \
    crate://crates.io/thiserror-impl/1.0.38 \
    crate://crates.io/thiserror/1.0.38 \
    crate://crates.io/thread_local/1.1.4 \
    crate://crates.io/time-core/0.1.0 \
    crate://crates.io/time-macros/0.2.6 \
    crate://crates.io/time/0.3.17 \
    crate://crates.io/toml/0.5.11 \
    crate://crates.io/toml_datetime/0.5.0 \
    crate://crates.io/toml_edit/0.17.1 \
    crate://crates.io/tracing-attributes/0.1.23 \
    crate://crates.io/tracing-core/0.1.30 \
    crate://crates.io/tracing-log/0.1.3 \
    crate://crates.io/tracing-serde/0.1.3 \
    crate://crates.io/tracing-subscriber/0.3.16 \
    crate://crates.io/tracing/0.1.37 \
    crate://crates.io/trycmd/0.14.10 \
    crate://crates.io/twox-hash/1.6.3 \
    crate://crates.io/unicase/2.6.0 \
    crate://crates.io/unicode-ident/1.0.6 \
    crate://crates.io/unicode-linebreak/0.1.4 \
    crate://crates.io/unicode-width/0.1.10 \
    crate://crates.io/uniffi_bindgen/0.22.0 \
    crate://crates.io/uniffi_checksum_derive/0.22.0 \
    crate://crates.io/uniffi_meta/0.22.0 \
    crate://crates.io/uniffi_testing/0.22.0 \
    crate://crates.io/untrusted/0.7.1 \
    crate://crates.io/ureq/2.6.2 \
    crate://crates.io/url/2.3.1 \
    crate://crates.io/uuid/1.3.0 \
    crate://crates.io/vcpkg/0.2.15 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/versions/4.1.0 \
    crate://crates.io/wait-timeout/0.2.0 \
    crate://crates.io/walkdir/2.3.2 \
    crate://crates.io/webpki-roots/0.22.6 \
    crate://crates.io/webpki/0.22.0 \
    crate://crates.io/weedle2/4.0.0 \
    crate://crates.io/which/4.4.0 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-sys/0.42.0 \
    crate://crates.io/windows_aarch64_gnullvm/0.42.1 \
    crate://crates.io/windows_aarch64_msvc/0.42.1 \
    crate://crates.io/windows_i686_gnu/0.42.1 \
    crate://crates.io/windows_i686_msvc/0.42.1 \
    crate://crates.io/windows_x86_64_gnu/0.42.1 \
    crate://crates.io/windows_x86_64_gnullvm/0.42.1 \
    crate://crates.io/windows_x86_64_msvc/0.42.1 \
    crate://crates.io/xattr/0.2.3 \
    crate://crates.io/xwin/0.2.10 \
    crate://crates.io/yansi/0.5.1 \
    crate://crates.io/zbus/1.9.3 \
    crate://crates.io/zbus_macros/1.9.3 \
    crate://crates.io/zip/0.6.4 \
    crate://crates.io/zvariant/2.10.0 \
    crate://crates.io/zvariant_derive/2.10.0 \
"

inherit pypi cargo native
