package me.xiaoying.livegetauthorize.core.event.user;

import me.xiaoying.livegetauthorize.core.classification.DisplayPage;
import me.xiaoying.livegetauthorize.core.entity.User;
import me.xiaoying.livegetauthorize.core.event.HandlerList;

/**
 * Event user open display page
 */
public class UserOpenDisplayPageEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    private final DisplayPage displayPage;

    public UserOpenDisplayPageEvent(User user, DisplayPage displayPage) {
        super(user);
        this.displayPage = displayPage;
    }

    /**
     * 获取被打开的 Display page
     *
     * @return DisplayPage
     */
    public DisplayPage getDisplayPage() {
        return this.displayPage;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}