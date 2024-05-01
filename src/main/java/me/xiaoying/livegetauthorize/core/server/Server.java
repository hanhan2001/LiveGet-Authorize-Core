package me.xiaoying.livegetauthorize.core.server;

import me.xiaoying.livegetauthorize.core.classification.ClassificationManager;
import me.xiaoying.livegetauthorize.core.command.CommandManager;
import me.xiaoying.livegetauthorize.core.permission.PermissionManager;
import me.xiaoying.livegetauthorize.core.plugin.PluginManager;
import me.xiaoying.livegetauthorize.core.scheduler.Scheduler;

/**
 * Server
 */
public interface Server {
    String getName();

    PluginManager getPluginManager();
    CommandManager getCommandManager();
    Scheduler getScheduler();
    PermissionManager getPermissionManager();
    void setPermissionManager(PermissionManager permissionManager);
    ClassificationManager getClassificationManager();

    void run();
    void stop();
}