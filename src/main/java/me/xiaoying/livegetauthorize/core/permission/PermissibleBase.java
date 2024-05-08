package me.xiaoying.livegetauthorize.core.permission;

import me.xiaoying.livegetauthorize.core.plugin.Plugin;

import java.util.*;

public class PermissibleBase implements Permissible {
    private final List<PermissionAttachment> attachments = new ArrayList<>();
    private final Map<String, Permission> knownPermissions = new HashMap<>();

    @Override
    public boolean isPermissionSet(String permission) {
        return this.knownPermissions.containsKey(permission.toLowerCase(Locale.ENGLISH));
    }

    @Override
    public boolean isPermissionSet(Permission permission) {
        return this.knownPermissions.containsKey(permission.getPermission().toLowerCase(Locale.ENGLISH));
    }

    @Override
    public boolean hasPermission(String permission) {
        // 是否注册权限
        if (!this.isPermissionSet(permission.toLowerCase(Locale.ENGLISH)))
            return false;
        // 是否拥有权限
        if (!this.knownPermissions.get(permission.toLowerCase(Locale.ENGLISH)).getValue())
            return false;
        // 是否过期
        if (this.knownPermissions.get(permission.toLowerCase(Locale.ENGLISH)).overDue())
            return false;
        return true;
    }

    @Override
    public boolean hasPermission(Permission permission) {
        // 是否注册权限
        if (!this.isPermissionSet(permission.getPermission()))
            return false;
        // 是否拥有权限
        if (!this.knownPermissions.get(permission.getPermission().toLowerCase(Locale.ENGLISH)).getValue())
            return false;
        // 是否过期
        if (this.knownPermissions.get(permission.getPermission().toLowerCase(Locale.ENGLISH)).overDue())
            return false;
        return true;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        if (!plugin.isEnabled())
            throw new IllegalArgumentException("Plugin " + plugin.getDescription().getName() + " is disabled.");
        PermissionAttachment permissionAttachment = new PermissionAttachment(this, plugin);
        this.attachments.add(permissionAttachment);
        this.recalculatePermissions();
        return permissionAttachment;
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        if (!this.attachments.contains(attachment))
            return;

        this.attachments.remove(attachment);
        this.recalculatePermissions();
    }


    public void recalculatePermissions() {
        this.clearPermission();

        this.attachments.forEach(attachment -> this.knownPermissions.putAll(attachment.getPermissions()));
    }

    public synchronized void clearPermission() {
        this.knownPermissions.clear();
    }
}