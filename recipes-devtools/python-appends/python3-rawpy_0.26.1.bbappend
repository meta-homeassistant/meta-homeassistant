RAWPY_USE_SYSTEM_LIBRAW = "1"
export VERBOSE = "1"

do_compile:prepend () {
	export RAWPY_USE_SYSTEM_LIBRAW="${RAWPY_USE_SYSTEM_LIBRAW}"
}
