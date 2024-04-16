package me.xiaoying.livegetauthorize.core.command.commands;

import me.xiaoying.livegetauthorize.core.LACore;
import me.xiaoying.livegetauthorize.core.command.Command;
import me.xiaoying.livegetauthorize.core.command.CommandSender;

/**
 * Command Help
 */
public class HelpCommand extends Command {
    public HelpCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        LACore.getServer().getCommandManager().getCommands().forEach(command -> {
            LACore.getLogger().info("{} &7-> &f{}", command.getName(), command.getDescription());

            if (command.getAlias() == null)
                return;

            for (String alias : command.getAlias())
                LACore.getLogger().info("{} &7-> &f{}", alias, command.getDescription());
        });
    }
}