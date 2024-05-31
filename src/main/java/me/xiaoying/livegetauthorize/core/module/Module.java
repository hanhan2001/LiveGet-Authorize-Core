package me.xiaoying.livegetauthorize.core.module;

import me.xiaoying.livegetauthorize.core.permission.Permission;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Module
 */
public class Module {
    private final String function;
    private final String description;
    private final String permission;
    private String identification;
    private final Map<String, ModuleChild> knownChild = new HashMap<>();
    private final Map<String, Token> knownToken = new HashMap<>();

    /**
     * 构造器
     *
     * @param function Function name
     * @param description 描述
     * @param permission 权限
     */
    public Module(String function, String description, String identification, String permission) {
        this.function = function;
        this.description = description;
        this.permission = permission;
        this.identification = identification;
    }

    /**
     * 构造器
     *
     * @param function Function name
     * @param description 描述
     * @param permission 权限
     */
    public Module(String function, String description, String identification, Permission permission) {
        this.function = function;
        this.description = description;
        this.permission = permission.getPermission();
        this.identification = identification;
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
     * 获取身份码
     *
     * @return String
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * 设置身份码
     *
     * @param identification String
     */
    public void setIdentification(String identification) {
        this.identification = identification;
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
     * 以字符串方式获取所有 ModuleChild
     *
     * @return String
     */
    public String getModuleChildrenAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ModuleChild value : this.knownChild.values()) {
            if (stringBuilder.length() != 0)
                stringBuilder.append(",");

            stringBuilder.append(value.getName() + "~" + value.getOwner().getUUID());
            if (value.getSave() != null && value.getOver() != null) {
                stringBuilder.append("~").append(new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(value.getSave()));
                stringBuilder.append("~").append(new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(value.getOver()));
            }
        }
        return stringBuilder.toString();
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