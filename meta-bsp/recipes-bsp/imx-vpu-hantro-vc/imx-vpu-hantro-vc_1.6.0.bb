# Copyright 2019-2021 NXP

DESCRIPTION = "i.MX vc8000e encoder library"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=28241cb895217d7946e40e7227136d02" 

SRC_URI[md5sum] = "d2c6eba0528de18ca6a35bceecf9e7bb"
SRC_URI[sha256sum] = "3ddd89de5773034b80af71ec96044a0147bcc3ad0851364ffda5831862ae9625"

inherit fsl-eula2-unpack2

COMPATIBLE_MACHINE = "(imx8mpevk)"
