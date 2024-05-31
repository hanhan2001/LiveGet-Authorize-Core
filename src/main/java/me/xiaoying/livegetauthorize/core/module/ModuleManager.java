package me.xiaoying.livegetauthorize.core.module;

import me.xiaoying.livegetauthorize.core.plugin.Plugin;

import java.util.List;

/**
 * Manager Module
 */
public interface ModuleManager {
    /**
     * 注册 Module
     *
     * @param plugin Plugin
     * @param module Module
     */
    void registerModule(Plugin plugin, Module module);

    /**
     * 取消注册 Module
     *
     * @param module Module
     */
    void unregisterModule(Module module);

    /**
     * 取消注册 Module
     *
     * @param module Module name of function
     */
    void unregisterModule(String module);

    /**
     * 取消注册 Module
     *
     * @param plugin Plugin
     */
    void unregisterModules(Plugin plugin);

    /**
     * 获取 Module
     *
     * @param function Module name of function
     * @return Module
     */
    Module getModule(String function);

    /**
     * 获取 Module
     *
     * @param identification Module identification
     * @return Module
     */
    Module getModuleByIdentification(String identification);

    /**
     * 获取所有 Module
     *
     * @return ArrayList
     */
    List<Module> getModules();
}