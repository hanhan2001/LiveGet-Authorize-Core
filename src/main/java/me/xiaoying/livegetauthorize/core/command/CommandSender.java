package me.xiaoying.livegetauthorize.core.command;

import me.xiaoying.livegetauthorize.core.permission.Permissible;

/**
 * Command Sender
 */
public interface CommandSender extends Permissible {
    String getName();

    void sendMessage(String message);
}