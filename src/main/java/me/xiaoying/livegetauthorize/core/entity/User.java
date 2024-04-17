package me.xiaoying.livegetauthorize.core.entity;

import me.xiaoying.livegetauthorize.core.command.CommandSender;

import java.util.Date;

/**
 * Entity User
 */
public interface User extends CommandSender {
    long getQQ();

    String getEmail();

    long getTelephone();

    String getUUID();

    String getPassword();

    String getIP();

    Date getRegisterTime();

    Date getLastLoginTime();
}