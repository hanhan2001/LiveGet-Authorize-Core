package me.xiaoying.livegetauthorize.core.classification;

import me.xiaoying.livegetauthorize.core.entity.User;
import me.xiaoying.livegetauthorize.core.permission.Permission;

/**
 * Classification DisplayPage
 */
public abstract class DisplayPage {
    private String name;
    private Permission permission;
    private final Classification classification;

    public DisplayPage(String name, Classification classification) {
        this.name = name;
        this.classification = classification;
    }

    public DisplayPage(String name, Classification classification, Permission permission) {
        this.name = name;
        this.permission = permission;
        this.classification = classification;
    }

    public String getName() {
        return name;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public Classification getClassification() {
        return this.classification;
    }

    public abstract void enable(User user);
}