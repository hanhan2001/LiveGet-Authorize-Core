package me.xiaoying.livegetauthorize.core.classification;

import me.xiaoying.livegetauthorize.core.permission.Permission;

/**
 * Classification DisplayPage
 */
public abstract class DisplayPage {
    private final Permission permission;

    public DisplayPage(Permission permission) {
        this.permission = permission;
    }

    public Permission getPermission() {
        return this.permission;
    }
}