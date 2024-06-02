package me.xiaoying.livegetauthorize.core.module;

/**
 * Manager Token
 */
public interface TokenManager {
    /**
     * 获取 Token
     *
     * @return Token
     */
    Token getToken(String token);

    /**
     * 创建授权码
     *
     * @param token Token
     */
    void create(Token token);

    /**
     * 移除 Token
     *
     * @param token Token as String
     */
    void delete(String token);

    /**
     * Token 是否已存在
     *
     * @param token Token
     * @return Boolean
     */
    boolean contains(String token);

    /**
     * 获取 Module
     *
     * @return Module
     */
    Module getModule();
}