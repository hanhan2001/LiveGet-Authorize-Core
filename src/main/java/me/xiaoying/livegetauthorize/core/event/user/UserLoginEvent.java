package me.xiaoying.livegetauthorize.core.event.user;

import me.xiaoying.livegetauthorize.core.entity.User;
import me.xiaoying.livegetauthorize.core.event.HandlerList;

/**
 * Event User login
 */
public class UserLoginEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    public UserLoginEvent(User user) {
        super(user);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}