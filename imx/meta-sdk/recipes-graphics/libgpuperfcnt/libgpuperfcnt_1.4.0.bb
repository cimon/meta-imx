DESCRIPTION = "A library to retrieve i.MX GPU performance data"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=75abe2fa1d16ca79f87cde926f05f72d"

SRC_URI[arm-fb.md5sum] = "8f8dd9b7854fafda153da8022c30e753"
SRC_URI[arm-fb.sha256sum] = "d1073d1543050370e851b6cd24a90d1d281176f4265cae9764cff9f9520863fe"

SRC_URI[arm-wayland.md5sum] = "2dd8afa63a2acbc81afe3e2085eff278"
SRC_URI[arm-wayland.sha256sum] = "dbd941567f9e5bc9d5263de7924553474965038bbd71de898223ce8d2a18f195"

SRC_URI[arm-x11.md5sum] = "279f3e31fa22521be90da3c0146873ef"
SRC_URI[arm-x11.sha256sum] = "607e5b4a3fc7fc0f1c0058d631b2e0332066adf95f33cf3d5f3da97433e9111e"

SRC_URI[aarch64-fb.md5sum] = "d78dd2dffb0ac1604eaf68c714dc56b2"
SRC_URI[aarch64-fb.sha256sum] = "91691597672f1693a5a07aef98051da1e7a2ca2d6d902241792c858a9463535f"

SRC_URI[aarch64-wayland.md5sum] = "95f4c82401595e3a24a68e727decc206"
SRC_URI[aarch64-wayland.sha256sum] = "0da967ccdc1099af33c0adb88671cabc421fd25c49b456d0ee9771ec12fb5090"

SRC_URI[aarch64-x11.md5sum] = "d901794f4df77b246bfea946baf1fe2e"
SRC_URI[aarch64-x11.sha256sum] = "9fd9bc56eb1f611f74528e5adb33c7c595a7c32520f0575542d3ffcd51dabb39"

inherit fsl-eula-unpack2 fsl-eula-graphics

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

RDEPENDS_${PN} = "imx-gpu-viv"

# Compatible only with i.MX with GPU
COMPATIBLE_MACHINE        = "(^$)"
COMPATIBLE_MACHINE_imxgpu = "${MACHINE}"
