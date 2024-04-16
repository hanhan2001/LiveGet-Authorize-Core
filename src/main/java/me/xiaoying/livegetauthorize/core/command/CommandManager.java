package me.xiaoying.livegetauthorize.core.command;

import me.xiaoying.livegetauthorize.core.plugin.Plugin;

import java.util.List;

/**
 * Command commandMap
 */
public interface CommandManager {
    void registerCommand(String fallbackPrefix, Command command);

    void registerCommand(Plugin plugin, Command command);

    void unregisterCommand(Plugin plugin, Command command);

    void unregisterCommands(Plugin plugin);

    boolean dispatch(CommandSender sender, String command);

    Command getCommand(String command);

    List<Command> getCommands();
}