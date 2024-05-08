package me.xiaoying.livegetauthorize.core.permission;

import me.xiaoying.livegetauthorize.core.plugin.Plugin;

public interface Permissible {
    boolean isPermissionSet(String permission);

    boolean isPermissionSet(Permission permission);

    boolean hasPermission(String permission);

    boolean hasPermission(Permission permission);

    PermissionAttachment addAttachment(Plugin plugin);

    void removeAttachment(PermissionAttachment attachment);
}