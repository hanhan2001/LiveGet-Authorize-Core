package me.xiaoying.livegetauthorize.core.module;

import java.util.List;

/**
 * Manager Module
 */
public interface ModuleManager {
    /**
     * 注册 Module
     *
     * @param module Module
     */
    void registerModule(Module module);

    /**
     * 取消注册 Module
     *
     * @param module Module
     */
    void unregisterModule(Module module);

    /**
     * 取消注册 Module
     *
     * @param function Module name of function
     */
    void unregisterModule(String function);

    /**
     * 获取 Module
     *
     * @param function Module name of function
     * @return Module
     */
    Module getModule(String function);

    /**
     * 获取所有 Module
     *
     * @return ArrayList
     */
    List<Module> getModules();
}