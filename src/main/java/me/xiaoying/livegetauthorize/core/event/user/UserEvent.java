package me.xiaoying.livegetauthorize.core.event.user;

import me.xiaoying.livegetauthorize.core.entity.User;
import me.xiaoying.livegetauthorize.core.event.Event;

/**
 * Event User
 */
public abstract class UserEvent extends Event {
    private final User user;

    public UserEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}