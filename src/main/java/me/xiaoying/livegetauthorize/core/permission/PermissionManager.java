package me.xiaoying.livegetauthorize.core.permission;

import me.xiaoying.livegetauthorize.core.entity.User;

/**
 * Permission manager interface
 */
public interface PermissionManager {
    void setPermission(User user, Permission permission);

    void setPermission(User user, String permission);

    boolean hasPermission(User user, String permission);
}