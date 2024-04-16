package me.xiaoying.livegetauthorize.core.plugin;

import me.xiaoying.livegetauthorize.core.command.Command;
import me.xiaoying.livegetauthorize.core.server.Server;

import java.io.File;

/**
 * Plugin
 */
public interface Plugin {
    File getDataFolder();

    void onLoad();
    void onEnable();
    void onDisable();
    boolean isEnabled();

    void saveConfig();
    void saveDefaultConfig();
    void saveResource(String filename, boolean replace);
    void registerCommand(Command command);

    Server getServer();

    PluginLoader getPluginloader();
    PluginDescriptionFile getDescription();
}