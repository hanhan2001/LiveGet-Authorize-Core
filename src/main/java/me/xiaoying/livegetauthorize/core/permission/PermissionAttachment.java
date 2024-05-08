package me.xiaoying.livegetauthorize.core.permission;

import me.xiaoying.livegetauthorize.core.plugin.Plugin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class PermissionAttachment {
    private final Permissible permissible;
    private final Plugin plugin;
    private final Map<String, Permission> permissions = new HashMap<>();

    public PermissionAttachment(Permissible permissible, Plugin plugin) {
        if (!plugin.isEnabled())
            throw new IllegalArgumentException("Plugin " + plugin.getDescription().getName() + " is disabled.");
        this.permissible = permissible;
        this.plugin = plugin;
    }

    public Plugin getPlugin() {
        return this.plugin;
    }

    public void setPermission(String permission, boolean value) {
        Permission perm = new Permission(permission, value);
        this.permissions.put(permission.toLowerCase(Locale.ENGLISH), perm);
    }

    public void setPermission(Permission permission, boolean value) {
        permission.setValue(value);
        this.permissions.put(permission.getPermission().toLowerCase(Locale.ENGLISH), permission);
    }

    public void unsetPermission(String permission) {
        if (!this.permissions.containsKey(permission))
            return;

        this.permissions.remove(permission);
    }

    public void unsetPermission(Permission permission) {
        if (!this.permissions.containsKey(permission.getPermission()))
            return;

        this.permissions.remove(permission.toString());
    }

    public Permissible getPermissible() {
        return this.permissible;
    }

    public Map<String, Permission> getPermissions() {
        return new LinkedHashMap<>(this.permissions);
    }

    public void remove() {
        this.permissible.removeAttachment(this);
    }
}