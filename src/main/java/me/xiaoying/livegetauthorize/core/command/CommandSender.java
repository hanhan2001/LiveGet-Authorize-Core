package me.xiaoying.livegetauthorize.core.command;

/**
 * Command Sender
 */
public interface CommandSender {
    boolean hasPermission(String permission);
}