package me.xiaoying.livegetauthorize.core.event;

/**
 * Event executor
 */
public interface EventExecutor {
    void execute(Listener listener, Event event) throws EventException;
}