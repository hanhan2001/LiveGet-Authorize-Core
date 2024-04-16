package me.xiaoying.livegetauthorize.core.event.server;

import me.xiaoying.livegetauthorize.core.event.Event;
import me.xiaoying.livegetauthorize.core.event.HandlerList;

/**
 * Event Server
 */
public class ServerEvent extends Event {
    public static HandlerList handlerList = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}