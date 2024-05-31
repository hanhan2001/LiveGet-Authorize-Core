package me.xiaoying.livegetauthorize.core.module;

import me.xiaoying.livegetauthorize.core.permission.Permission;

import java.util.HashMap;
import java.util.Map;

/**
 * Module
 */
public class Module {
    private final String function;
    private final String description;
    private final String permission;
    private final Map<String, ModuleChild> knownChild = new HashMap<>();

    /**
     * 构造器
     *
     * @param function Function name
     * @param description 描述
     * @param permission 权限
     */
    public Module(String function, String description, String permission) {
        this.function = function;
        this.description = description;
        this.permission = permission;
    }

    /**
     * 构造器
     *
     * @param function Function name
     * @param description 描述
     * @param permission 权限
     */
    public Module(String function, String description, Permission permission) {
        this.function = function;
        this.description = description;
        this.permission = permission.getPermission();
    }

    /**
     * 获取 Function
     *
     * @return String
     */
    public String getFunction() {
        return this.function;
    }

    /**
     * 获取描述
     *
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 获取权限
     *
     * @return String
     */
    public String getPermission() {
        return this.permission;
    }

    /**
     * 注册子 Module
     *
     * @param moduleChild ModuleChild
     */
    public void registerChild(ModuleChild moduleChild) {
        this.knownChild.put(moduleChild.getName(), moduleChild);
    }

    /**
     * 获取子 Module
     *
     * @param name ModuleChild name
     * @return ModuleChild
     */
    public ModuleChild getModuleChild(String name) {
        return this.knownChild.get(name);
    }

    /**
     * 卸载 ModuleChild
     *
     * @param name ModuleChild name
     */
    public void unregisterModuleChild(String name) {
        this.knownChild.remove(name);
    }

    /**
     * 卸载所有 ModuleChild
     */
    public void unregisterModuleChildren() {
        this.knownChild.clear();
    }
}