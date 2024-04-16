package me.xiaoying.livegetauthorize.core.entity;


import me.xiaoying.livegetauthorize.core.command.CommandSender;

/**
 * Entity User
 */
public class User extends CommandSender {
    long qq;
    private String uuid;
    private String password;

    public User(String uuid) {

    }
}