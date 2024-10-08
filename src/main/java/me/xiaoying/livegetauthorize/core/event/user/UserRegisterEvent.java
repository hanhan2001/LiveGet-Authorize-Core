package me.xiaoying.livegetauthorize.core.event.user;

import me.xiaoying.livegetauthorize.core.entity.User;
import me.xiaoying.livegetauthorize.core.event.HandlerList;

/**
 * Event User register
 */
public class UserRegisterEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    public UserRegisterEvent(User user) {
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