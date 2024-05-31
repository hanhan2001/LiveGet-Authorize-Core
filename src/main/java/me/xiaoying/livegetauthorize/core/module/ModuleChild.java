package me.xiaoying.livegetauthorize.core.module;

import me.xiaoying.livegetauthorize.core.entity.User;

import java.util.Date;

/**
 * Module Child
 */
public class ModuleChild {
    private User owner;
    private String name;
    private Date save;
    private Date over;
    private final Module module;

    /**
     * 构造器
     *
     * @param name 名称
     * @param save 存储时间
     * @param over 过期时间
     * @param owner 拥有者
     * @param module 来源 Module
     */
    public ModuleChild(String name, Date save, Date over, User owner, Module module) {
        this.name = name;
        this.save = save;
        this.over = over;
        this.owner = owner;
        this.module = module;
    }

    /**
     * 获取 ModuleChild 名称
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 ModuleChild 名称
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取存储时间
     *
     * @return Date
     */
    public Date getSave() {
        return this.save;
    }

    /**
     * 设置存储时间
     *
     * @param save
     */
    public void setSave(Date save) {
        this.save = save;
    }

    /**
     * 获取过期时间
     *
     * @return Date
     */
    public Date getOver() {
        return this.over;
    }

    /**
     * 设置过期时间
     *
     * @param over
     */
    public void setOver(Date over) {
        this.over = over;
    }

    /**
     * 获取 Module Child 的拥有者
     *
     * @return User
     */
    public User getOwner() {
        return this.owner;
    }

    /**
     * 获取来源 Module
     *
     * @return Module
     */
    public Module getModule() {
        return this.module;
    }

    /**
     * 是否过期
     *
     * @return Boolean
     */
    public boolean overdue() {
        if (this.save == null || this.over == null)
            return false;

        return new Date().getTime() - this.over.getTime() > 0;
    }
}