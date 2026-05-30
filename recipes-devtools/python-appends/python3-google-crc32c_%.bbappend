export CRC32C_PURE_PYTHON = "0"

# The extension pulls in C++ runtime symbols from bundled crc32c objects.
# Distutils injects LDFLAGS before objects; force retention despite --as-needed.
LDFLAGS:append = " -Wl,--no-as-needed -lstdc++ -Wl,--as-needed"
