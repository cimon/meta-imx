SECTION = "devel"
SUMMARY = "Linux Trace Toolkit KERNEL MODULE"
DESCRIPTION = "The lttng-modules 2.0 package contains the kernel tracer modules"
LICENSE = "LGPL-2.1-only & GPL-2.0-only & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3f882d431dc0f32f1f44c0707aa41128"

inherit module

COMPATIBLE_HOST = '(x86_64|i.86|powerpc|aarch64|mips|nios2|arm|riscv).*-linux'

SRC_URI = "https://lttng.org/files/${BPN}/${BPN}-${PV}.tar.bz2 \
           file://Makefile-Do-not-fail-if-CONFIG_TRACEPOINTS-is-not-en.patch \
           file://BUILD_RUNTIME_BUG_ON-vs-gcc7.patch \
           file://0001-Fix-writeback_queue_io-issue-with-kernel-5.4.62.patch \
           "

SRC_URI[sha256sum] = "d3e5648937e59dee983ef844f9316c55e9961f9dc8515b9260c473bbb70696c1"

export INSTALL_MOD_DIR="kernel/lttng-modules"

EXTRA_OEMAKE += "KERNELDIR='${STAGING_KERNEL_DIR}'"

do_install:append() {
	# Delete empty directories to avoid QA failures if no modules were built
	find ${D}/${nonarch_base_libdir} -depth -type d -empty -exec rmdir {} \;
}

python do_package:prepend() {
    if not os.path.exists(os.path.join(d.getVar('D'), d.getVar('nonarch_base_libdir')[1:], 'modules')):
        bb.warn("%s: no modules were created; this may be due to CONFIG_TRACEPOINTS not being enabled in your kernel." % d.getVar('PN'))
}

BBCLASSEXTEND = "devupstream:target"
LIC_FILES_CHKSUM:class-devupstream = "file://LICENSE;md5=3f882d431dc0f32f1f44c0707aa41128"
DEFAULT_PREFERENCE:class-devupstream = "-1"
SRC_URI:class-devupstream = "git://git.lttng.org/lttng-modules;branch=stable-2.11 \
           file://Makefile-Do-not-fail-if-CONFIG_TRACEPOINTS-is-not-en.patch \
           file://BUILD_RUNTIME_BUG_ON-vs-gcc7.patch \
           "
SRCREV:class-devupstream = "6ad0e68b43c3e52fcb3d47c4d823a7b84aeb443a"
PV:class-devupstream = "2.11.1+git${SRCPV}"
S:class-devupstream = "${WORKDIR}/git"
SRCREV_FORMAT ?= "lttng_git"

