package me.xiaoying.livegetauthorize.core.event;

/**
 * Event cancellable
 */
public interface Cancellable {
    boolean isCancelled();
    void setCancelled(boolean cancelled);
}