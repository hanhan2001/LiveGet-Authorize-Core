package me.xiaoying.livegetauthorize.core.plugin;

public class IllegalPluginAccessException extends RuntimeException {
    public IllegalPluginAccessException() {
    }

    public IllegalPluginAccessException(String msg) {
        super(msg);
    }
}