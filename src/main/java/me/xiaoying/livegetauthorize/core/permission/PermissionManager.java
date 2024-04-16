package me.xiaoying.livegetauthorize.core.permission;

import me.xiaoying.livegetauthorize.core.entity.User;

/**
 * Permission manager interface
 */
public interface PermissionManager {
    boolean hasPermission(User user, String permission);
}