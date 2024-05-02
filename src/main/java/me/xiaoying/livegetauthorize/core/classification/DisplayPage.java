package me.xiaoying.livegetauthorize.core.classification;

import me.xiaoying.livegetauthorize.core.entity.User;
import me.xiaoying.livegetauthorize.core.permission.Permission;

/**
 * Classification DisplayPage
 */
public abstract class DisplayPage {
    private String name;
    private final Permission permission;

    public DisplayPage(String name) {
        this(name, null);
    }

    public DisplayPage(String name, Permission permission) {
        this.name = name;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public abstract void enable();

    public abstract void disable();

    public abstract void onEnable();

    public abstract void onDisable();
}