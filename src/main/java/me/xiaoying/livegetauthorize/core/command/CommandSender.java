package me.xiaoying.livegetauthorize.core.command;

/**
 * Command Sender
 */
public interface CommandSender {
    String getName();

    boolean hasPermission(String permission);
}