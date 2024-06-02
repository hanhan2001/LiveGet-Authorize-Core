package me.xiaoying.livegetauthorize.core.module;

import me.xiaoying.livegetauthorize.core.entity.User;

import java.util.Date;

public interface Token {
    /**
     * 获取 Token
     *
     * @return String
     */
    String getToken();

    /**
     * 获取 Token 拥有者
     *
     * @return User
     */
    User getOwner();

    /**
     * 获取描述
     *
     * @return String
     */
    String getDescription();

    /**
     * 设置描述
     *
     * @param description 描述
     */
    void setDescription(String description);

    /**
     * 获取存储时间
     *
     * @return Date
     */
    Date getSave();

    /**
     * 设置存储时间
     *
     * @param date Date
     */
    void setSave(Date date);

    /**
     * 获取过期时间
     *
     * @return Date
     */
    Date getOver();

    /**
     * 设置过期时间
     *
     * @param date Date
     */
    void setOver(Date date);

    /**
     * 获取 Module
     *
     * @return Module
     */
    Module getModule();

    /**
     * 是否过期
     *
     * @return Boolean
     */
    boolean overdue();

    /**
     * 是否存活
     *
     * @return Boolean
     */
    boolean isSurvival();
}