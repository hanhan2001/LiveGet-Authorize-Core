package me.xiaoying.livegetauthorize.core.event.user;

import me.xiaoying.livegetauthorize.core.classification.Classification;
import me.xiaoying.livegetauthorize.core.entity.User;
import me.xiaoying.livegetauthorize.core.event.HandlerList;

public class UserOpenClassificationEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    private final Classification classification;

    public UserOpenClassificationEvent(User user, Classification classification) {
        super(user);
        this.classification = classification;
    }

    /**
     * 获取被打开的 Classification
     *
     * @return Classification
     */
    public Classification getClassification() {
        return this.classification;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}