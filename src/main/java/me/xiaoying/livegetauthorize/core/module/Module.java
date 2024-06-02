package me.xiaoying.livegetauthorize.core.module;

import me.xiaoying.livegetauthorize.core.entity.User;
import me.xiaoying.livegetauthorize.core.plugin.Plugin;

import java.util.Date;

/**
 * Module
 */
public interface Module {
    /**
     * 获取拥有者
     *
     * @return User
     */
    User getOwner();

    /**
     * 获取名称
     *
     * @return String
     */
    String getName();

    /**
     * 获取描述
     *
     * @return String
     */
    String getDescription();

    /**
     * 获取权限
     *
     * @return String
     */
    String getPermission();

    /**
     * 获取身份码
     *
     * @return String
     */
    String getIdentification();

    /**
     * 设置身份码
     *
     * @param identification String
     */
    void setIdentification(String identification);

    /**
     * 获取存储时间
     *
     * @return Date
     */
    Date getSave();

    /**
     * 获取过期时间
     *
     * @return Date
     */
    Date getOver();

    /**
     * 是否过期
     *
     * @return Boolean
     */
    boolean overdue();

    /**
     * 获取父 Module
     *
     * @return Module
     */
    Module getParent();

    /**
     * 注册子 Module
     *
     * @param module Module
     * @param plugin 插件
     */
    void registerModuleChild(Module module, Plugin plugin);

    /**
     * 获取子 Module
     *
     * @param name ModuleChild name
     * @return ModuleChild
     */
    Module getModuleChild(String name);

    /**
     * 以字符串方式获取所有 ModuleChild
     *
     * @return String
     */
    String getModuleChildrenAsString();

    /**
     * 卸载 ModuleChild
     *
     * @param name ModuleChild name
     */
    void unregisterModuleChild(String name);

    /**
     * 卸载所有 ModuleChild
     */
    void unregisterModuleChildren();

    /**
     * 获取 Token Manager
     *
     * @return TokenManager
     */
    TokenManager getTokenManager();

    @Override
    String toString();
}