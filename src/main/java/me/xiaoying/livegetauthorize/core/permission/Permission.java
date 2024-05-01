package me.xiaoying.livegetauthorize.core.permission;

import java.util.Date;

/**
 * Permission
 */
public class Permission {
    private String permission;
    private Date save;
    private Date over;

    public Permission(String permission) {
        this.permission = permission;
    }

    public Permission(String permission, Date save, Date over) {
        this.permission = permission;
        this.save = save;
        this.over = over;
    }

    public String getPermission() {
        return this.permission;
    }

    public Date getSave() {
        return this.save;
    }

    public void setSave(Date save) {
        this.save = save;
    }

    public Date getOver() {
        return this.over;
    }

    public void setOver(Date over) {
        this.over = over;
    }
}