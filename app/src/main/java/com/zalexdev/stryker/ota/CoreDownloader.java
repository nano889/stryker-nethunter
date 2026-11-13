package com.zalexdev.stryker.ota;

import android.content.Context;

public final class CoreDownloader {

    private CoreDownloader() {
    }

    /**
     * NetHunter port: resolve the chroot rootfs to install.
     *
     * Upstream asked the remote manifest first, which is how the Debian rootfs was
     * chosen. That manifest still describes Debian, so honouring it would undo the
     * port on every fresh install. We therefore resolve the pinned NetHunter asset
     * directly and only fall back to the manifest when explicitly re-enabled.
     */
    public static RemoteManifest.Asset resolve(Context context) {
        if (StrykerEndpoints.USE_REMOTE_MANIFEST_FOR_CHROOT) {
            RemoteManifest manifest = ManifestService.fetch(context);
            if (manifest != null && manifest.chroot64 != null && manifest.chroot64.isUsable()) {
                return manifest.chroot64;
            }
        }
        return new RemoteManifest.Asset(
                StrykerEndpoints.FALLBACK_CHROOT_64,
                StrykerEndpoints.FALLBACK_CHROOT_64_SHA256,
                StrykerEndpoints.FALLBACK_CHROOT_64_SIZE);
    }
}
