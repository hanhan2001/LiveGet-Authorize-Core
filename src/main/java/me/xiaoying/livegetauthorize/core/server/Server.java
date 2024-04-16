package me.xiaoying.livegetauthorize.core.server;

import me.xiaoying.livegetauthorize.core.command.CommandManager;
import me.xiaoying.livegetauthorize.core.plugin.PluginManager;

/**
 * Server
 */
public interface Server {
    String getName();

    PluginManager getPluginManager();
    CommandManager getCommandManager();

    void run();
    void stop();
}