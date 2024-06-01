package me.xiaoying.livegetauthorize.core.server;

import me.xiaoying.livegetauthorize.core.classification.ClassificationManager;
import me.xiaoying.livegetauthorize.core.command.CommandManager;
import me.xiaoying.livegetauthorize.core.message.MessageManager;
import me.xiaoying.livegetauthorize.core.module.ModuleManager;
import me.xiaoying.livegetauthorize.core.option.OptionManager;
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

    ClassificationManager getClassificationManager();

    MessageManager getMessageManager();

    OptionManager getOptionManager();

    ModuleManager getModuleManager();

    void run();

    void stop();
}