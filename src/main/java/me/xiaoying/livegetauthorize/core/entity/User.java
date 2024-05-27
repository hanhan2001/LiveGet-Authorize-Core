package me.xiaoying.livegetauthorize.core.entity;

import me.xiaoying.livegetauthorize.core.command.CommandSender;

import java.util.Date;

/**
 * Entity User
 */
public interface User extends CommandSender {
    /**
     * 获取 QQ
     *
     * @return 用户QQ
     */
    long getQQ();

    /**
     * 获取 邮件
     *
     * @return 用户邮件
     */
    String getEmail();

    /**
     * 获取 手机号
     *
     * @return 用户手机号
     */
    long getTelephone();

    /**
     * 获取 UUID
     *
     * @return 用户UUID
     */
    String getUUID();

    String getPassword();

    /**
     * 获取 登录IP
     *
     * @return 用户登录IP
     */
    String getIP();

    /**
     * 获取注册时间
     *
     * @return 用户注册时间
     */
    Date getRegisterTime();

    /**
     * 获取 最后登录时间
     *
     * @return 用户最后登陆时间
     */
    Date getLastLoginTime();

    /**
     * 获取 是否存活<br>
     * 缓存实体，避免同时刻存在用户实体过多导致系统效率缓慢
     *
     * @return 用户实体是否存活
     */
    boolean isSurvival();

    /**
     * 刷新用户实体缓存
     */
    void updateSurvival();

    /**
     * 获取 登录Token
     *
     * @return 获取用户登录 Token
     */
    String getToken();

    /**
     * 设置 登录Token
     *
     * @param token 用户Token
     */
    void setToken(String token);

    /**
     * 获取 头像
     *
     * @return 用户
     */
    String getPhotoBase64();
}