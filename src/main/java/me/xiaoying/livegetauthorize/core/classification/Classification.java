package me.xiaoying.livegetauthorize.core.classification;

import me.xiaoying.livegetauthorize.core.NamespacedKey;
import me.xiaoying.livegetauthorize.core.entity.User;
import me.xiaoying.livegetauthorize.core.permission.Permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classification
 */
public abstract class Classification {
    private String name;
    private Permission permission;
    private final Map<String, DisplayPage> knownDisplayPage = new HashMap<>();

    public Classification(String name) {
        this(name, null);
    }

    public Classification(String name, Permission permission) {
        this.name = name;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public Permission getPermission() {
        return this.permission;
    }

    /**
     * 获取 DisplayPage
     *
     * @param name Page name
     * @return DisplayPage
     */
    public DisplayPage getPage(String name) {
        return this.knownDisplayPage.get(name);
    }

    /**
     * 注册分类页面
     *
     * @param namespacedKey Page name
     * @param displayPage Page
     */
    public void registerPage(NamespacedKey namespacedKey,DisplayPage displayPage) {
        if (this.knownDisplayPage.get(namespacedKey.toString()) != null)
            return;

        this.knownDisplayPage.put(namespacedKey.toString(), displayPage);
    }

    /**
     * 移除 DisplayPage
     *
     * @param name Page name
     */
    public void unregisterPage(String name) {
        this.knownDisplayPage.remove(name);
    }

    public List<DisplayPage> getPages() {
        return new ArrayList<>(this.knownDisplayPage.values());
    }

    public abstract void enable(User user);

    public abstract void disable(User user);

    public abstract void onEnable(User user);

    public abstract void onDisable(User user);
}