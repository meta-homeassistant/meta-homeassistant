SUMMARY = "Fast transfer of large files with the Hugging Face Hub."
HOMEPAGE = "https://github.com/huggingface/xet-core"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://hf_xet/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a8c27070ca547293b6890c4bf389f713f80e8c478631432962bb7f4bc0bd7d7f"

require ${BPN}-crates.inc

inherit pypi python_maturin cargo-update-recipe-crates

PYPI_PACKAGE = "hf_xet"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

# Consolidated remap prefixes to avoid embedding absolute build/source paths.
# Keep a small set of high-yield prefixes rather than many overlapping ones.
RUST_DEBUG_REMAP = " --remap-path-prefix=${S}=${TARGET_DBGSRC_DIR} --remap-path-prefix=${TMPDIR}=${TARGET_DBGSRC_DIR} --remap-path-prefix=/usr/src/debug=${TARGET_DBGSRC_DIR} --remap-path-prefix=/cache/builddir=${TARGET_DBGSRC_DIR} --remap-path-prefix=${CARGO_HOME}=${TARGET_DBGSRC_DIR}"

# Disable generation of Rust debug info to avoid embedding build paths.
RUSTFLAGS += " -C debuginfo=0 ${RUST_DEBUG_REMAP}"
export RUSTFLAGS

# Ensure any remaining debug symbols in the compiled .so are stripped
do_install:append() {
	# remove debug sections that may contain absolute build paths
	find ${D} -type f -name "*.so" -print0 | xargs -0 -r ${OBJCOPY} --remove-section .debug_info --remove-section .debug_line --remove-section .debug_str --remove-section .debug_loc --remove-section .debug_abbrev --remove-section .gnu_debuglink || true
	# fallback strip of any remaining symbols
	find ${D} -type f -name "*.so" -exec ${STRIP} --strip-debug {} \; || true

	# Post-install: scan installed shared objects and scrub embedded absolute
	# build/source paths by replacing them with ${TARGET_DBGSRC_DIR} (padded
	# with NULs to keep binary size unchanged). This is a last-resort
	# remediation for buildpath strings that weren't removed by remap flags.
	python3 - <<"PY"
from pathlib import Path
patterns = [
	"${S}",
	"${WORKDIR}",
	"${TMPDIR}",
	"${B}",
	"${TOPDIR}",
	"/usr/src/debug",
	"/cache/builddir",
	"${CARGO_HOME}",
]
target = "${TARGET_DBGSRC_DIR}"
dst = Path("${D}")
for so in dst.rglob('*.so'):
	try:
		data = so.read_bytes()
	except Exception:
		continue
	orig = data
	repl = target.encode()
	for p in patterns:
		if not p:
			continue
		pb = p.encode()
		if len(pb) == 0:
			continue
		# Truncate or pad the replacement to match the pattern length so
		# replacements are done in-place without changing binary layout.
		if len(repl) >= len(pb):
			repl_padded = repl[: len(pb)]
		else:
			repl_padded = repl + b"\x00" * (len(pb) - len(repl))
		data = data.replace(pb, repl_padded)
	if data != orig:
		so.write_bytes(data)
		print("patched:", so)
PY
}
