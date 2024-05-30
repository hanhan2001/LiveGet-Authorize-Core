package me.xiaoying.livegetauthorize.core.command;

import me.xiaoying.livegetauthorize.core.LACore;
import me.xiaoying.livegetauthorize.core.NamespacedKey;
import me.xiaoying.livegetauthorize.core.command.commands.HelpCommand;
import me.xiaoying.livegetauthorize.core.plugin.Plugin;

import java.util.*;

/**
 * Command commandMap SimpleCommandMap
 */
public class SimpleCommandManager implements CommandManager {
    private final Map<String, Command> knownCommand = new HashMap<>();

    public SimpleCommandManager() {
        this.registerCommand("authorizecore", new HelpCommand("help"));
    }

    @Override
    public void registerCommand(String fallbackPrefix, Command command) {
        this.knownCommand.put(fallbackPrefix + ":" + command.getName(), command);
    }

    public void registerCommand(Plugin plugin, Command command) {
        this.knownCommand.put(new NamespacedKey(plugin, command.getName()).toString(), command);

        if (command.getAlias() == null)
            return;

        for (String alias : command.getAlias())
            this.knownCommand.put(new NamespacedKey(plugin, alias).toString(), command);
    }

    public void unregisterCommand(Plugin plugin, Command command) {
        this.knownCommand.remove(new NamespacedKey(plugin, command.getName()).toString());

        if (command.getAlias().isEmpty())
            return;

        for (String alias : command.getAlias())
            this.knownCommand.remove(new NamespacedKey(plugin, alias).toString());
    }

    public void unregisterCommands(Plugin plugin) {
        Iterator<String> iterator = this.knownCommand.keySet().iterator();
        String string;
        while (iterator.hasNext() && (string = iterator.next()) != null) {
            if (string.isEmpty())
                continue;

            if (!string.startsWith(plugin.getDescription().getName() + ":"))
                continue;

            iterator.remove();
        }
    }

    public void unregisterCommands() {
        this.knownCommand.clear();
    }

    @Override
    public boolean dispatch(CommandSender sender, String command) {
        boolean result = false;
        if (command == null || command.isEmpty())
            return result;

        String[] split = command.split(" ");

        if (split.length == 0)
            return result;

        String head = split[0];
        head = this.matchCommand(head);
        if (head == null)
            return result;

        Command cmd = this.knownCommand.get(head);
        if (cmd == null)
            return false;

        String[] args = null;
        if (split.length != 1)
            args = new ArrayList<>(Arrays.asList(split).subList(1, split.length)).toArray(new String[0]);
        try {
            cmd.execute(sender, args);
        } catch (Exception e) {
            LACore.getLogger().error(e.getMessage());
        }
        return true;
    }

    @Override
    public Command getCommand(String command) {
        return null;
    }

    @Override
    public List<Command> getCommands() {
        return new ArrayList<>(this.knownCommand.values());
    }

    private String matchCommand(String command) {
        if (command.contains(":"))
            return command;

        for (String s : this.knownCommand.keySet()) {
            if (!s.endsWith(":" + command))
                continue;
            if (s.startsWith("authorizecore:"))
                continue;

            return s;
        }

        if (this.knownCommand.get("authorizecore:" + command) != null)
            return "authorizecore:" + command;
        return null;
    }
}