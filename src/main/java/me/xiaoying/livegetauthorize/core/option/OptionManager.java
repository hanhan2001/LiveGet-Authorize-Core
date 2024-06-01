package me.xiaoying.livegetauthorize.core.option;

import java.util.List;

public interface OptionManager {
    /**
     * 注册 Option
     *
     * @param option Option
     */
    void registerOption(Option option);

    /**
     * 注册 Option
     *
     * @param name 名称
     * @param value 值
     */
    void registerOption(String name, String value);

    /**
     * 取消注册 Option
     *
     * @param name 名称
     */
    void unregisterOption(String name);

    /**
     * 取消注册所有 Option
     */
    void unregisterOptions();

    /**
     * 获取 Option
     *
     * @param name 名称
     * @return Option
     */
    Option getOption(String name);

    /**
     * 获取所有 Option
     *
     * @return Option
     */
    List<Option> getOptions();
}