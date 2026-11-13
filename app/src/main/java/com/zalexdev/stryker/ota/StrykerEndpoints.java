package com.zalexdev.stryker.ota;

public final class StrykerEndpoints {

    public static final String GITHUB_REPO = "https://github.com/zalexdev/strykerapp";

    public static final String MANIFEST_URL =
            "https://raw.githubusercontent.com/zalexdev/strykerapp/main/stryker_manifest.json";

    /**
     * NetHunter port: the chroot rootfs is now Kali NetHunter minimal (arm64).
     *
     * Upstream pointed this at chroot64-debian.tar.gz. We point it at the official
     * Kali NetHunter minimal rootfs instead, and pin the SHA-256 published in
     * https://kali.download/nethunter-images/current/rootfs/SHA256SUMS so the
     * download is verified end to end.
     *
     * The archive is .tar.xz and unpacks into a single top-level "kali-arm64/"
     * directory, which the installer re-roots into /data/local/stryker/release.
     */
    public static final String FALLBACK_CHROOT_64 =
            "https://kali.download/nethunter-images/current/rootfs/kali-nethunter-rootfs-minimal-arm64.tar.xz";

    /** SHA-256 of kali-nethunter-rootfs-minimal-arm64.tar.xz (2026.3, 125846088 bytes). */
    public static final String FALLBACK_CHROOT_64_SHA256 =
            "96aeced81a857a987715a14417af05c2934e3e19052d6151c398a1c215448b60";

    public static final long FALLBACK_CHROOT_64_SIZE = 125846088L;

    /**
     * NetHunter port: the upstream OTA manifest describes the Debian rootfs and
     * would silently repoint the installer back at it. We no longer read it for
     * the chroot, so this is kept only for the app-update/news blocks.
     */
    public static final boolean USE_REMOTE_MANIFEST_FOR_CHROOT = false;

    private static final String ROOTLESS_BASE =
            "https://github.com/zalexdev/strykerapp/releases/download/rootless-main/";
    public static final String FALLBACK_ROOTLESS_QEMU     = ROOTLESS_BASE + "qemu-system-aarch64";
    public static final String FALLBACK_ROOTLESS_KERNEL   = ROOTLESS_BASE + "Image";
    public static final String FALLBACK_ROOTLESS_LIBSLIRP = ROOTLESS_BASE + "libslirp.so";
    public static final String FALLBACK_ROOTLESS_INITRD   = ROOTLESS_BASE + "initrd.img";
    public static final String FALLBACK_ROOTLESS_ROOTFS   = ROOTLESS_BASE + "rootfs.imgz";

    public static final String PREFS = "stryker_ota";

    private StrykerEndpoints() {
    }
}
