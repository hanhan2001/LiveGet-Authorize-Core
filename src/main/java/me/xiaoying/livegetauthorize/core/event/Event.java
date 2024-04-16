package me.xiaoying.livegetauthorize.core.event;

public abstract class Event implements Cancellable {
    private boolean cancelled;

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public abstract HandlerList getHandlers();
}